package org.jsoup.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.helper.DescendableLinkedList;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.parser.Token;
import org.jsoup.select.Elements;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class HtmlTreeBuilder extends TreeBuilder {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final String[] TagSearchButton;
    private static final String[] TagSearchEndTags;
    private static final String[] TagSearchList;
    private static final String[] TagSearchSelectScope;
    private static final String[] TagSearchSpecial;
    private static final String[] TagSearchTableScope;
    private static final String[] TagsScriptStyle;
    public static final String[] TagsSearchInScope;
    private Element contextElement;
    private FormElement formElement;
    private Element headElement;
    private HtmlTreeBuilderState originalState;
    private HtmlTreeBuilderState state;
    private boolean baseUriSetFromDoc = false;
    private DescendableLinkedList<Element> formattingElements = new DescendableLinkedList<>();
    private List<Token.Character> pendingTableCharacters = new ArrayList();
    private boolean framesetOk = true;
    private boolean fosterInserts = false;
    private boolean fragmentParsing = false;

    static {
        $assertionsDisabled = !HtmlTreeBuilder.class.desiredAssertionStatus();
        TagsScriptStyle = new String[]{"script", "style"};
        TagsSearchInScope = new String[]{"applet", "caption", "html", "table", "td", "th", "marquee", "object"};
        TagSearchList = new String[]{"ol", "ul"};
        TagSearchButton = new String[]{"button"};
        TagSearchTableScope = new String[]{"html", "table"};
        TagSearchSelectScope = new String[]{"optgroup", "option"};
        TagSearchEndTags = new String[]{"dd", "dt", "li", "option", "optgroup", "p", "rp", "rt"};
        TagSearchSpecial = new String[]{"address", "applet", "area", "article", "aside", "base", "basefont", "bgsound", "blockquote", "body", "br", "button", "caption", "center", "col", "colgroup", "command", "dd", "details", "dir", "div", "dl", "dt", "embed", "fieldset", "figcaption", "figure", "footer", "form", "frame", "frameset", "h1", "h2", "h3", "h4", "h5", "h6", "head", "header", "hgroup", "hr", "html", "iframe", "img", "input", "isindex", "li", "link", "listing", "marquee", "menu", "meta", "nav", "noembed", "noframes", "noscript", "object", "ol", "p", "param", "plaintext", "pre", "script", "section", "select", "style", "summary", "table", "tbody", "td", "textarea", "tfoot", "th", "thead", "title", "tr", "ul", "wbr", "xmp"};
    }

    @Override // org.jsoup.parser.TreeBuilder
    Document parse(String str, String str2, ParseErrorList parseErrorList) {
        this.state = HtmlTreeBuilderState.Initial;
        return super.parse(str, str2, parseErrorList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Node> parseFragment(String str, Element element, String str2, ParseErrorList parseErrorList) {
        this.state = HtmlTreeBuilderState.Initial;
        initialiseParse(str, str2, parseErrorList);
        this.contextElement = element;
        this.fragmentParsing = true;
        Element element2 = null;
        if (element != null) {
            if (element.ownerDocument() != null) {
                this.doc.quirksMode(element.ownerDocument().quirksMode());
            }
            String tagName = element.tagName();
            if (StringUtil.in(tagName, "title", "textarea")) {
                this.tokeniser.transition(TokeniserState.Rcdata);
            } else if (StringUtil.in(tagName, "iframe", "noembed", "noframes", "style", "xmp")) {
                this.tokeniser.transition(TokeniserState.Rawtext);
            } else if (tagName.equals("script")) {
                this.tokeniser.transition(TokeniserState.ScriptData);
            } else if (tagName.equals("noscript")) {
                this.tokeniser.transition(TokeniserState.Data);
            } else if (tagName.equals("plaintext")) {
                this.tokeniser.transition(TokeniserState.Data);
            } else {
                this.tokeniser.transition(TokeniserState.Data);
            }
            Element element3 = new Element(Tag.valueOf("html"), str2);
            this.doc.appendChild(element3);
            this.stack.push(element3);
            resetInsertionMode();
            Elements parents = element.parents();
            parents.add(0, element);
            Iterator<Element> it = parents.iterator();
            while (true) {
                if (!it.hasNext()) {
                    element2 = element3;
                    break;
                }
                Element next = it.next();
                if (next instanceof FormElement) {
                    this.formElement = (FormElement) next;
                    element2 = element3;
                    break;
                }
            }
        }
        runParser();
        if (element != null) {
            return element2.childNodes();
        }
        return this.doc.childNodes();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jsoup.parser.TreeBuilder
    public boolean process(Token token) {
        this.currentToken = token;
        return this.state.process(token, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean process(Token token, HtmlTreeBuilderState htmlTreeBuilderState) {
        this.currentToken = token;
        return htmlTreeBuilderState.process(token, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void transition(HtmlTreeBuilderState htmlTreeBuilderState) {
        this.state = htmlTreeBuilderState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HtmlTreeBuilderState state() {
        return this.state;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void markInsertionMode() {
        this.originalState = this.state;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HtmlTreeBuilderState originalState() {
        return this.originalState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void framesetOk(boolean z) {
        this.framesetOk = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean framesetOk() {
        return this.framesetOk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Document getDocument() {
        return this.doc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getBaseUri() {
        return this.baseUri;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void maybeSetBaseUri(Element element) {
        if (!this.baseUriSetFromDoc) {
            String absUrl = element.absUrl("href");
            if (absUrl.length() != 0) {
                this.baseUri = absUrl;
                this.baseUriSetFromDoc = true;
                this.doc.setBaseUri(absUrl);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isFragmentParsing() {
        return this.fragmentParsing;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void error(HtmlTreeBuilderState htmlTreeBuilderState) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), "Unexpected token [%s] when in state [%s]", this.currentToken.tokenType(), htmlTreeBuilderState));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Element insert(Token.StartTag startTag) {
        if (startTag.isSelfClosing()) {
            Element insertEmpty = insertEmpty(startTag);
            this.stack.add(insertEmpty);
            this.tokeniser.transition(TokeniserState.Data);
            this.tokeniser.emit(new Token.EndTag(insertEmpty.tagName()));
            return insertEmpty;
        }
        Element element = new Element(Tag.valueOf(startTag.name()), this.baseUri, startTag.attributes);
        insert(element);
        return element;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Element insert(String str) {
        Element element = new Element(Tag.valueOf(str), this.baseUri);
        insert(element);
        return element;
    }

    void insert(Element element) {
        insertNode(element);
        this.stack.add(element);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Element insertEmpty(Token.StartTag startTag) {
        Tag valueOf = Tag.valueOf(startTag.name());
        Element element = new Element(valueOf, this.baseUri, startTag.attributes);
        insertNode(element);
        if (startTag.isSelfClosing()) {
            if (valueOf.isKnownTag()) {
                if (valueOf.isSelfClosing()) {
                    this.tokeniser.acknowledgeSelfClosingFlag();
                }
            } else {
                valueOf.setSelfClosing();
                this.tokeniser.acknowledgeSelfClosingFlag();
            }
        }
        return element;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FormElement insertForm(Token.StartTag startTag, boolean z) {
        FormElement formElement = new FormElement(Tag.valueOf(startTag.name()), this.baseUri, startTag.attributes);
        setFormElement(formElement);
        insertNode(formElement);
        if (z) {
            this.stack.add(formElement);
        }
        return formElement;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void insert(Token.Comment comment) {
        insertNode(new Comment(comment.getData(), this.baseUri));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void insert(Token.Character character) {
        Node textNode;
        if (StringUtil.in(currentElement().tagName(), TagsScriptStyle)) {
            textNode = new DataNode(character.getData(), this.baseUri);
        } else {
            textNode = new TextNode(character.getData(), this.baseUri);
        }
        currentElement().appendChild(textNode);
    }

    private void insertNode(Node node) {
        if (this.stack.size() == 0) {
            this.doc.appendChild(node);
        } else if (isFosterInserts()) {
            insertInFosterParent(node);
        } else {
            currentElement().appendChild(node);
        }
        if ((node instanceof Element) && ((Element) node).tag().isFormListed() && this.formElement != null) {
            this.formElement.addElement((Element) node);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Element pop() {
        if (this.stack.peekLast().nodeName().equals("td") && !this.state.name().equals("InCell")) {
            Validate.isFalse(true, "pop td not in cell");
        }
        if (this.stack.peekLast().nodeName().equals("html")) {
            Validate.isFalse(true, "popping html!");
        }
        return this.stack.pollLast();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void push(Element element) {
        this.stack.add(element);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DescendableLinkedList<Element> getStack() {
        return this.stack;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onStack(Element element) {
        return isElementInQueue(this.stack, element);
    }

    private boolean isElementInQueue(DescendableLinkedList<Element> descendableLinkedList, Element element) {
        Iterator<Element> descendingIterator = descendableLinkedList.descendingIterator();
        while (descendingIterator.hasNext()) {
            if (descendingIterator.next() == element) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Element getFromStack(String str) {
        Iterator<Element> descendingIterator = this.stack.descendingIterator();
        while (descendingIterator.hasNext()) {
            Element next = descendingIterator.next();
            if (next.nodeName().equals(str)) {
                return next;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean removeFromStack(Element element) {
        Iterator<Element> descendingIterator = this.stack.descendingIterator();
        while (descendingIterator.hasNext()) {
            if (descendingIterator.next() == element) {
                descendingIterator.remove();
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void popStackToClose(String str) {
        Iterator<Element> descendingIterator = this.stack.descendingIterator();
        while (descendingIterator.hasNext()) {
            if (descendingIterator.next().nodeName().equals(str)) {
                descendingIterator.remove();
                return;
            }
            descendingIterator.remove();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void popStackToClose(String... strArr) {
        Iterator<Element> descendingIterator = this.stack.descendingIterator();
        while (descendingIterator.hasNext()) {
            if (StringUtil.in(descendingIterator.next().nodeName(), strArr)) {
                descendingIterator.remove();
                return;
            }
            descendingIterator.remove();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void popStackToBefore(String str) {
        Iterator<Element> descendingIterator = this.stack.descendingIterator();
        while (descendingIterator.hasNext() && !descendingIterator.next().nodeName().equals(str)) {
            descendingIterator.remove();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearStackToTableContext() {
        clearStackToContext("table");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearStackToTableBodyContext() {
        clearStackToContext("tbody", "tfoot", "thead");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearStackToTableRowContext() {
        clearStackToContext("tr");
    }

    private void clearStackToContext(String... strArr) {
        Iterator<Element> descendingIterator = this.stack.descendingIterator();
        while (descendingIterator.hasNext()) {
            Element next = descendingIterator.next();
            if (!StringUtil.in(next.nodeName(), strArr) && !next.nodeName().equals("html")) {
                descendingIterator.remove();
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Element aboveOnStack(Element element) {
        if ($assertionsDisabled || onStack(element)) {
            Iterator<Element> descendingIterator = this.stack.descendingIterator();
            while (descendingIterator.hasNext()) {
                if (descendingIterator.next() == element) {
                    return descendingIterator.next();
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void insertOnStackAfter(Element element, Element element2) {
        int lastIndexOf = this.stack.lastIndexOf(element);
        Validate.isTrue(lastIndexOf != -1);
        this.stack.add(lastIndexOf + 1, element2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void replaceOnStack(Element element, Element element2) {
        replaceInQueue(this.stack, element, element2);
    }

    private void replaceInQueue(LinkedList<Element> linkedList, Element element, Element element2) {
        int lastIndexOf = linkedList.lastIndexOf(element);
        Validate.isTrue(lastIndexOf != -1);
        linkedList.remove(lastIndexOf);
        linkedList.add(lastIndexOf, element2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:71:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void resetInsertionMode() {
        Element element;
        boolean z = false;
        Iterator<Element> descendingIterator = this.stack.descendingIterator();
        while (true) {
            boolean z2 = z;
            if (descendingIterator.hasNext()) {
                Element next = descendingIterator.next();
                if (descendingIterator.hasNext()) {
                    z = z2;
                    element = next;
                } else {
                    z = true;
                    element = this.contextElement;
                }
                String nodeName = element.nodeName();
                if ("select".equals(nodeName)) {
                    transition(HtmlTreeBuilderState.InSelect);
                    return;
                } else if ("td".equals(nodeName) || ("td".equals(nodeName) && !z)) {
                    break;
                } else if ("tr".equals(nodeName)) {
                    transition(HtmlTreeBuilderState.InRow);
                    return;
                } else if ("tbody".equals(nodeName) || "thead".equals(nodeName) || "tfoot".equals(nodeName)) {
                    break;
                } else if ("caption".equals(nodeName)) {
                    transition(HtmlTreeBuilderState.InCaption);
                    return;
                } else if ("colgroup".equals(nodeName)) {
                    transition(HtmlTreeBuilderState.InColumnGroup);
                    return;
                } else if ("table".equals(nodeName)) {
                    transition(HtmlTreeBuilderState.InTable);
                    return;
                } else if ("head".equals(nodeName)) {
                    transition(HtmlTreeBuilderState.InBody);
                    return;
                } else if ("body".equals(nodeName)) {
                    transition(HtmlTreeBuilderState.InBody);
                    return;
                } else if ("frameset".equals(nodeName)) {
                    transition(HtmlTreeBuilderState.InFrameset);
                    return;
                } else if ("html".equals(nodeName)) {
                    transition(HtmlTreeBuilderState.BeforeHead);
                    return;
                } else if (z) {
                    transition(HtmlTreeBuilderState.InBody);
                    return;
                }
            } else {
                return;
            }
        }
        transition(HtmlTreeBuilderState.InCell);
    }

    private boolean inSpecificScope(String str, String[] strArr, String[] strArr2) {
        return inSpecificScope(new String[]{str}, strArr, strArr2);
    }

    private boolean inSpecificScope(String[] strArr, String[] strArr2, String[] strArr3) {
        Iterator<Element> descendingIterator = this.stack.descendingIterator();
        while (descendingIterator.hasNext()) {
            String nodeName = descendingIterator.next().nodeName();
            if (StringUtil.in(nodeName, strArr)) {
                return true;
            }
            if (StringUtil.in(nodeName, strArr2)) {
                return false;
            }
            if (strArr3 != null && StringUtil.in(nodeName, strArr3)) {
                return false;
            }
        }
        Validate.fail("Should not be reachable");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean inScope(String[] strArr) {
        return inSpecificScope(strArr, TagsSearchInScope, (String[]) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean inScope(String str) {
        return inScope(str, null);
    }

    boolean inScope(String str, String[] strArr) {
        return inSpecificScope(str, TagsSearchInScope, strArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean inListItemScope(String str) {
        return inScope(str, TagSearchList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean inButtonScope(String str) {
        return inScope(str, TagSearchButton);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean inTableScope(String str) {
        return inSpecificScope(str, TagSearchTableScope, (String[]) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean inSelectScope(String str) {
        Iterator<Element> descendingIterator = this.stack.descendingIterator();
        while (descendingIterator.hasNext()) {
            String nodeName = descendingIterator.next().nodeName();
            if (nodeName.equals(str)) {
                return true;
            }
            if (!StringUtil.in(nodeName, TagSearchSelectScope)) {
                return false;
            }
        }
        Validate.fail("Should not be reachable");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setHeadElement(Element element) {
        this.headElement = element;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Element getHeadElement() {
        return this.headElement;
    }

    boolean isFosterInserts() {
        return this.fosterInserts;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFosterInserts(boolean z) {
        this.fosterInserts = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FormElement getFormElement() {
        return this.formElement;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFormElement(FormElement formElement) {
        this.formElement = formElement;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void newPendingTableCharacters() {
        this.pendingTableCharacters = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Token.Character> getPendingTableCharacters() {
        return this.pendingTableCharacters;
    }

    void setPendingTableCharacters(List<Token.Character> list) {
        this.pendingTableCharacters = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void generateImpliedEndTags(String str) {
        while (str != null && !currentElement().nodeName().equals(str) && StringUtil.in(currentElement().nodeName(), TagSearchEndTags)) {
            pop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void generateImpliedEndTags() {
        generateImpliedEndTags(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isSpecial(Element element) {
        return StringUtil.in(element.nodeName(), TagSearchSpecial);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pushActiveFormattingElements(Element element) {
        Element next;
        int i = 0;
        Iterator<Element> descendingIterator = this.formattingElements.descendingIterator();
        while (true) {
            int i2 = i;
            if (!descendingIterator.hasNext() || (next = descendingIterator.next()) == null) {
                break;
            }
            i = isSameFormattingElement(element, next) ? i2 + 1 : i2;
            if (i == 3) {
                descendingIterator.remove();
                break;
            }
        }
        this.formattingElements.add(element);
    }

    private boolean isSameFormattingElement(Element element, Element element2) {
        return element.nodeName().equals(element2.nodeName()) && element.attributes().equals(element2.attributes());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reconstructFormattingElements() {
        int i;
        Element element;
        boolean z;
        int size = this.formattingElements.size();
        if (size != 0 && this.formattingElements.getLast() != null && !onStack(this.formattingElements.getLast())) {
            int i2 = size - 1;
            Element last = this.formattingElements.getLast();
            while (true) {
                if (i2 == 0) {
                    i = i2;
                    element = last;
                    z = true;
                    break;
                }
                i2--;
                Element element2 = this.formattingElements.get(i2);
                if (element2 == null) {
                    z = false;
                    element = element2;
                    i = i2;
                    break;
                } else if (onStack(element2)) {
                    z = false;
                    element = element2;
                    i = i2;
                    break;
                } else {
                    last = element2;
                }
            }
            while (true) {
                if (!z) {
                    int i3 = i + 1;
                    element = this.formattingElements.get(i3);
                    i = i3;
                }
                Validate.notNull(element);
                Element insert = insert(element.nodeName());
                insert.attributes().addAll(element.attributes());
                this.formattingElements.add(i, insert);
                this.formattingElements.remove(i + 1);
                if (i == size - 1) {
                    return;
                }
                z = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearFormattingElementsToLastMarker() {
        while (!this.formattingElements.isEmpty()) {
            Element peekLast = this.formattingElements.peekLast();
            this.formattingElements.removeLast();
            if (peekLast == null) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeFromActiveFormattingElements(Element element) {
        Iterator<Element> descendingIterator = this.formattingElements.descendingIterator();
        while (descendingIterator.hasNext()) {
            if (descendingIterator.next() == element) {
                descendingIterator.remove();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInActiveFormattingElements(Element element) {
        return isElementInQueue(this.formattingElements, element);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Element getActiveFormattingElement(String str) {
        Element next;
        Iterator<Element> descendingIterator = this.formattingElements.descendingIterator();
        while (descendingIterator.hasNext() && (next = descendingIterator.next()) != null) {
            if (next.nodeName().equals(str)) {
                return next;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void replaceActiveFormattingElement(Element element, Element element2) {
        replaceInQueue(this.formattingElements, element, element2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void insertMarkerToFormattingElements() {
        this.formattingElements.add(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void insertInFosterParent(Node node) {
        Element element;
        boolean z;
        Element fromStack = getFromStack("table");
        if (fromStack != null) {
            if (fromStack.parent() != null) {
                element = fromStack.parent();
                z = true;
            } else {
                element = aboveOnStack(fromStack);
                z = false;
            }
        } else {
            element = this.stack.get(0);
            z = false;
        }
        if (z) {
            Validate.notNull(fromStack);
            fromStack.before(node);
            return;
        }
        element.appendChild(node);
    }

    public String toString() {
        return "TreeBuilder{currentToken=" + this.currentToken + ", state=" + this.state + ", currentElement=" + currentElement() + '}';
    }
}
