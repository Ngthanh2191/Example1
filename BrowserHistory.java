import java.util.Stack;

public class BrowserHistory {
    private Stack<String> historyStack;
    private String currentPage;

    public BrowserHistory() {
        historyStack = new Stack<>();
        currentPage = "";
    }

    public void visitPage(String url) {
        if (!currentPage.isEmpty()) {
            historyStack.push(currentPage);
        }
        currentPage = url;
        System.out.println("Visiting: " + url);
    }

    public void goBack() {
        if (!historyStack.isEmpty()) {
            currentPage = historyStack.pop();
            System.out.println("Going back to: " + currentPage);
        } else {
            System.out.println("No more pages to go back to!");
        }
    }

    public void goForward(String url) {
        visitPage(url);
    }

    public static void main(String[] args) {
        BrowserHistory browser = new BrowserHistory();

        // Visit a few pages
        browser.visitPage("www.example.com");
        browser.visitPage("www.example.com/page1");
        browser.visitPage("www.example.com/page2");

        // Go back to previous pages
        browser.goBack();  
        browser.goBack();
        browser.goBack();
        // Go forward to a new page
        browser.goForward("www.example.com/page1");
    }
}
