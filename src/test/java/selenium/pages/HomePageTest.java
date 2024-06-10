package selenium.pages;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.base.MainTest;


public class HomePageTest extends MainTest {

    @Test
    public void testCreateProject() throws InterruptedException {
        LoginPage loginPage = new LoginPage(); //връзка с LoginPage
        HomePage homePage = new HomePage();
        loginPage.clickSignInButton();
        loginPage.setUsernameField("martinnenchev1@gmail.com");
        loginPage.setPasswordField("Martin_nenchev1");
        loginPage.clickInnerSignInButton();
        homePage.clickGlobalCreateMenu();
        homePage.waitForElementToBeClickable();
        homePage.clickCreateNewProjectButton();

        Assert.assertEquals("Welcome to projects", homePage.getWelcomeToProjectsMessage());
    }
    @Test
    public void testRenameProject() throws InterruptedException {
        LoginPage loginPage = new LoginPage(); //връзка с LoginPage
        HomePage homePage = new HomePage();
        loginPage.clickSignInButton();
        loginPage.setUsernameField("martinnenchev1@gmail.com");
        loginPage.setPasswordField("martinnenchev1@gmail.com");
        loginPage.clickInnerSignInButton();
        homePage.clickGlobalCreateMenu();
        homePage.waitForElementToBeClickable();
        homePage.clickCreateNewProjectButton();
        homePage.clickNewProjectButton();
        homePage.waitForTemplateDialogWindow();
        homePage.closeProjectTemplateDialog();
        homePage.clickSelectProject();
        homePage.clickProjectNameField();
        homePage.clearProjectNameField();
        homePage.waitProjectNameField();
        homePage.renameProject("TestProject1");
        homePage.clickSaveProjectButton();
    }
    @Test
    public void testDeleteProject() throws InterruptedException {
        LoginPage loginPage = new LoginPage(); //връзка с LoginPage
        HomePage homePage = new HomePage();
        loginPage.clickSignInButton();
        loginPage.setUsernameField("martinnenchev1@gmail.com");
        loginPage.setPasswordField("martinnenchev1@gmail.com");
        loginPage.clickInnerSignInButton();
        homePage.clickGlobalCreateMenu();
        homePage.waitForElementToBeClickable();
        homePage.clickCreateNewProjectButton();
        homePage.clickNewProjectButton();
        homePage.waitForTemplateDialogWindow();
        homePage.closeProjectTemplateDialog();
        homePage.clickSelectProject();
        homePage.clickProjectNameField();
        homePage.clearProjectNameField();
        homePage.waitProjectNameField();
        homePage.renameProject("TestProject1");
        homePage.clickSaveProjectButton();
        homePage.clickDeleteProjectButton();
        homePage.setConfirmDeleteInput("@MartinNenchev's untitled projectTestProject1");
        homePage.clickDeleteCurrentProjectButton();

        Assert.assertEquals("Your project \"@MartinNenchev's untitled projectTestProject1\" was successfully deleted.", homePage.getMessageContainerForDeleteProject());
    }
    @Test
    public void testCreateRenameDeleteRepo () {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        loginPage.clickSignInButton();
        loginPage.setUsernameField("martinnenchev1@gmail.com");
        loginPage.setPasswordField("martinnenchev1@gmail.com");
        loginPage.clickInnerSignInButton();
        homePage.clickReppoNameField();
        homePage.renameReppo("test");
        homePage.clickCreateNewReppoButton();
        homePage.clickSettingsButton();
        homePage.clickDeleteRepoButton();
        homePage.clickRepoDeleteProceedButton();
        homePage.clickRepoDeleteProceedButton();
        homePage.setRepoDeleteConfirmationField("MartinNenchev/test");
        homePage.clickRepoDeleteFinalButton();
        Assert.assertEquals("Your repository \"MartinNenchev/test\" was successfully deleted.", homePage.getDeleteRepoMessageContainer());
    }
}
