package org.jsoup.parser;

import com.baidu.tbadk.TbConfig;
import java.util.Iterator;
import org.jsoup.helper.DescendableLinkedList;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.nodes.Node;
import org.jsoup.parser.Token;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public enum HtmlTreeBuilderState {
    Initial { // from class: org.jsoup.parser.HtmlTreeBuilderState.1
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                return true;
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype()) {
                Token.Doctype asDoctype = token.asDoctype();
                htmlTreeBuilder.getDocument().appendChild(new DocumentType(asDoctype.getName(), asDoctype.getPublicIdentifier(), asDoctype.getSystemIdentifier(), htmlTreeBuilder.getBaseUri()));
                if (asDoctype.isForceQuirks()) {
                    htmlTreeBuilder.getDocument().quirksMode(Document.QuirksMode.quirks);
                }
                htmlTreeBuilder.transition(BeforeHtml);
                return true;
            } else {
                htmlTreeBuilder.transition(BeforeHtml);
                return htmlTreeBuilder.process(token);
            }
        }
    },
    BeforeHtml { // from class: org.jsoup.parser.HtmlTreeBuilderState.2
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            }
            if (!token.isComment()) {
                if (HtmlTreeBuilderState.isWhitespace(token)) {
                    return true;
                }
                if (token.isStartTag() && token.asStartTag().name().equals("html")) {
                    htmlTreeBuilder.insert(token.asStartTag());
                    htmlTreeBuilder.transition(BeforeHead);
                } else if (token.isEndTag() && StringUtil.in(token.asEndTag().name(), "head", "body", "html", "br")) {
                    return anythingElse(token, htmlTreeBuilder);
                } else {
                    if (token.isEndTag()) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    return anythingElse(token, htmlTreeBuilder);
                }
            } else {
                htmlTreeBuilder.insert(token.asComment());
            }
            return true;
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.insert("html");
            htmlTreeBuilder.transition(BeforeHead);
            return htmlTreeBuilder.process(token);
        }
    },
    BeforeHead { // from class: org.jsoup.parser.HtmlTreeBuilderState.3
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                return true;
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (token.isStartTag() && token.asStartTag().name().equals("html")) {
                return InBody.process(token, htmlTreeBuilder);
            } else {
                if (token.isStartTag() && token.asStartTag().name().equals("head")) {
                    htmlTreeBuilder.setHeadElement(htmlTreeBuilder.insert(token.asStartTag()));
                    htmlTreeBuilder.transition(InHead);
                    return true;
                } else if (token.isEndTag() && StringUtil.in(token.asEndTag().name(), "head", "body", "html", "br")) {
                    htmlTreeBuilder.process(new Token.StartTag("head"));
                    return htmlTreeBuilder.process(token);
                } else if (token.isEndTag()) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else {
                    htmlTreeBuilder.process(new Token.StartTag("head"));
                    return htmlTreeBuilder.process(token);
                }
            }
        }
    },
    InHead { // from class: org.jsoup.parser.HtmlTreeBuilderState.4
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            switch (token.type) {
                case Comment:
                    htmlTreeBuilder.insert(token.asComment());
                    return true;
                case Doctype:
                    htmlTreeBuilder.error(this);
                    return false;
                case StartTag:
                    Token.StartTag asStartTag = token.asStartTag();
                    String name = asStartTag.name();
                    if (name.equals("html")) {
                        return InBody.process(token, htmlTreeBuilder);
                    }
                    if (StringUtil.in(name, "base", "basefont", "bgsound", "command", "link")) {
                        Element insertEmpty = htmlTreeBuilder.insertEmpty(asStartTag);
                        if (name.equals("base") && insertEmpty.hasAttr("href")) {
                            htmlTreeBuilder.maybeSetBaseUri(insertEmpty);
                            return true;
                        }
                        return true;
                    } else if (name.equals("meta")) {
                        htmlTreeBuilder.insertEmpty(asStartTag);
                        return true;
                    } else if (name.equals("title")) {
                        HtmlTreeBuilderState.handleRcData(asStartTag, htmlTreeBuilder);
                        return true;
                    } else if (StringUtil.in(name, "noframes", "style")) {
                        HtmlTreeBuilderState.handleRawtext(asStartTag, htmlTreeBuilder);
                        return true;
                    } else if (name.equals("noscript")) {
                        htmlTreeBuilder.insert(asStartTag);
                        htmlTreeBuilder.transition(InHeadNoscript);
                        return true;
                    } else if (name.equals("script")) {
                        htmlTreeBuilder.tokeniser.transition(TokeniserState.ScriptData);
                        htmlTreeBuilder.markInsertionMode();
                        htmlTreeBuilder.transition(Text);
                        htmlTreeBuilder.insert(asStartTag);
                        return true;
                    } else if (name.equals("head")) {
                        htmlTreeBuilder.error(this);
                        return false;
                    } else {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                case EndTag:
                    String name2 = token.asEndTag().name();
                    if (name2.equals("head")) {
                        htmlTreeBuilder.pop();
                        htmlTreeBuilder.transition(AfterHead);
                        return true;
                    } else if (StringUtil.in(name2, "body", "html", "br")) {
                        return anythingElse(token, htmlTreeBuilder);
                    } else {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                default:
                    return anythingElse(token, htmlTreeBuilder);
            }
        }

        private boolean anythingElse(Token token, TreeBuilder treeBuilder) {
            treeBuilder.process(new Token.EndTag("head"));
            return treeBuilder.process(token);
        }
    },
    InHeadNoscript { // from class: org.jsoup.parser.HtmlTreeBuilderState.5
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
            } else if (token.isStartTag() && token.asStartTag().name().equals("html")) {
                return htmlTreeBuilder.process(token, InBody);
            } else {
                if (!token.isEndTag() || !token.asEndTag().name().equals("noscript")) {
                    if (HtmlTreeBuilderState.isWhitespace(token) || token.isComment() || (token.isStartTag() && StringUtil.in(token.asStartTag().name(), "basefont", "bgsound", "link", "meta", "noframes", "style"))) {
                        return htmlTreeBuilder.process(token, InHead);
                    }
                    if (token.isEndTag() && token.asEndTag().name().equals("br")) {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    if ((token.isStartTag() && StringUtil.in(token.asStartTag().name(), "head", "noscript")) || token.isEndTag()) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    return anythingElse(token, htmlTreeBuilder);
                }
                htmlTreeBuilder.pop();
                htmlTreeBuilder.transition(InHead);
            }
            return true;
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.error(this);
            htmlTreeBuilder.process(new Token.EndTag("noscript"));
            return htmlTreeBuilder.process(token);
        }
    },
    AfterHead { // from class: org.jsoup.parser.HtmlTreeBuilderState.6
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
            } else if (token.isStartTag()) {
                Token.StartTag asStartTag = token.asStartTag();
                String name = asStartTag.name();
                if (name.equals("html")) {
                    return htmlTreeBuilder.process(token, InBody);
                }
                if (name.equals("body")) {
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.framesetOk(false);
                    htmlTreeBuilder.transition(InBody);
                } else if (name.equals("frameset")) {
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(InFrameset);
                } else if (StringUtil.in(name, "base", "basefont", "bgsound", "link", "meta", "noframes", "script", "style", "title")) {
                    htmlTreeBuilder.error(this);
                    Element headElement = htmlTreeBuilder.getHeadElement();
                    htmlTreeBuilder.push(headElement);
                    htmlTreeBuilder.process(token, InHead);
                    htmlTreeBuilder.removeFromStack(headElement);
                } else if (name.equals("head")) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else {
                    anythingElse(token, htmlTreeBuilder);
                }
            } else if (!token.isEndTag()) {
                anythingElse(token, htmlTreeBuilder);
            } else if (StringUtil.in(token.asEndTag().name(), "body", "html")) {
                anythingElse(token, htmlTreeBuilder);
            } else {
                htmlTreeBuilder.error(this);
                return false;
            }
            return true;
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.process(new Token.StartTag("body"));
            htmlTreeBuilder.framesetOk(true);
            return htmlTreeBuilder.process(token);
        }
    },
    InBody { // from class: org.jsoup.parser.HtmlTreeBuilderState.7
        /* JADX WARN: Removed duplicated region for block: B:368:0x091c  */
        /* JADX WARN: Removed duplicated region for block: B:374:0x0954 A[LOOP:9: B:373:0x0952->B:374:0x0954, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:381:0x0983  */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            Element element;
            Element element2;
            boolean z;
            Element element3;
            switch (token.type) {
                case Comment:
                    htmlTreeBuilder.insert(token.asComment());
                    break;
                case Doctype:
                    htmlTreeBuilder.error(this);
                    return false;
                case StartTag:
                    Token.StartTag asStartTag = token.asStartTag();
                    String name = asStartTag.name();
                    if (name.equals("html")) {
                        htmlTreeBuilder.error(this);
                        Element first = htmlTreeBuilder.getStack().getFirst();
                        Iterator<Attribute> it = asStartTag.getAttributes().iterator();
                        while (it.hasNext()) {
                            Attribute next = it.next();
                            if (!first.hasAttr(next.getKey())) {
                                first.attributes().put(next);
                            }
                        }
                        break;
                    } else if (StringUtil.in(name, Constants.InBodyStartToHead)) {
                        return htmlTreeBuilder.process(token, InHead);
                    } else {
                        if (name.equals("body")) {
                            htmlTreeBuilder.error(this);
                            DescendableLinkedList<Element> stack = htmlTreeBuilder.getStack();
                            if (stack.size() == 1 || (stack.size() > 2 && !stack.get(1).nodeName().equals("body"))) {
                                return false;
                            }
                            htmlTreeBuilder.framesetOk(false);
                            Element element4 = stack.get(1);
                            Iterator<Attribute> it2 = asStartTag.getAttributes().iterator();
                            while (it2.hasNext()) {
                                Attribute next2 = it2.next();
                                if (!element4.hasAttr(next2.getKey())) {
                                    element4.attributes().put(next2);
                                }
                            }
                            break;
                        } else if (name.equals("frameset")) {
                            htmlTreeBuilder.error(this);
                            DescendableLinkedList<Element> stack2 = htmlTreeBuilder.getStack();
                            if (stack2.size() == 1 || ((stack2.size() > 2 && !stack2.get(1).nodeName().equals("body")) || !htmlTreeBuilder.framesetOk())) {
                                return false;
                            }
                            Element element5 = stack2.get(1);
                            if (element5.parent() != null) {
                                element5.remove();
                            }
                            while (stack2.size() > 1) {
                                stack2.removeLast();
                            }
                            htmlTreeBuilder.insert(asStartTag);
                            htmlTreeBuilder.transition(InFrameset);
                            break;
                        } else if (StringUtil.in(name, Constants.InBodyStartPClosers)) {
                            if (htmlTreeBuilder.inButtonScope("p")) {
                                htmlTreeBuilder.process(new Token.EndTag("p"));
                            }
                            htmlTreeBuilder.insert(asStartTag);
                            break;
                        } else if (StringUtil.in(name, Constants.Headings)) {
                            if (htmlTreeBuilder.inButtonScope("p")) {
                                htmlTreeBuilder.process(new Token.EndTag("p"));
                            }
                            if (StringUtil.in(htmlTreeBuilder.currentElement().nodeName(), Constants.Headings)) {
                                htmlTreeBuilder.error(this);
                                htmlTreeBuilder.pop();
                            }
                            htmlTreeBuilder.insert(asStartTag);
                            break;
                        } else if (StringUtil.in(name, Constants.InBodyStartPreListing)) {
                            if (htmlTreeBuilder.inButtonScope("p")) {
                                htmlTreeBuilder.process(new Token.EndTag("p"));
                            }
                            htmlTreeBuilder.insert(asStartTag);
                            htmlTreeBuilder.framesetOk(false);
                            break;
                        } else if (name.equals("form")) {
                            if (htmlTreeBuilder.getFormElement() != null) {
                                htmlTreeBuilder.error(this);
                                return false;
                            }
                            if (htmlTreeBuilder.inButtonScope("p")) {
                                htmlTreeBuilder.process(new Token.EndTag("p"));
                            }
                            htmlTreeBuilder.insertForm(asStartTag, true);
                            break;
                        } else if (name.equals("li")) {
                            htmlTreeBuilder.framesetOk(false);
                            DescendableLinkedList<Element> stack3 = htmlTreeBuilder.getStack();
                            int size = stack3.size() - 1;
                            while (true) {
                                if (size > 0) {
                                    Element element6 = stack3.get(size);
                                    if (element6.nodeName().equals("li")) {
                                        htmlTreeBuilder.process(new Token.EndTag("li"));
                                    } else if (!htmlTreeBuilder.isSpecial(element6) || StringUtil.in(element6.nodeName(), Constants.InBodyStartLiBreakers)) {
                                        size--;
                                    }
                                }
                            }
                            if (htmlTreeBuilder.inButtonScope("p")) {
                                htmlTreeBuilder.process(new Token.EndTag("p"));
                            }
                            htmlTreeBuilder.insert(asStartTag);
                            break;
                        } else if (StringUtil.in(name, Constants.DdDt)) {
                            htmlTreeBuilder.framesetOk(false);
                            DescendableLinkedList<Element> stack4 = htmlTreeBuilder.getStack();
                            int size2 = stack4.size() - 1;
                            while (true) {
                                if (size2 > 0) {
                                    Element element7 = stack4.get(size2);
                                    if (StringUtil.in(element7.nodeName(), Constants.DdDt)) {
                                        htmlTreeBuilder.process(new Token.EndTag(element7.nodeName()));
                                    } else if (!htmlTreeBuilder.isSpecial(element7) || StringUtil.in(element7.nodeName(), Constants.InBodyStartLiBreakers)) {
                                        size2--;
                                    }
                                }
                            }
                            if (htmlTreeBuilder.inButtonScope("p")) {
                                htmlTreeBuilder.process(new Token.EndTag("p"));
                            }
                            htmlTreeBuilder.insert(asStartTag);
                            break;
                        } else if (name.equals("plaintext")) {
                            if (htmlTreeBuilder.inButtonScope("p")) {
                                htmlTreeBuilder.process(new Token.EndTag("p"));
                            }
                            htmlTreeBuilder.insert(asStartTag);
                            htmlTreeBuilder.tokeniser.transition(TokeniserState.PLAINTEXT);
                            break;
                        } else if (name.equals("button")) {
                            if (htmlTreeBuilder.inButtonScope("button")) {
                                htmlTreeBuilder.error(this);
                                htmlTreeBuilder.process(new Token.EndTag("button"));
                                htmlTreeBuilder.process(asStartTag);
                                break;
                            } else {
                                htmlTreeBuilder.reconstructFormattingElements();
                                htmlTreeBuilder.insert(asStartTag);
                                htmlTreeBuilder.framesetOk(false);
                                break;
                            }
                        } else if (name.equals("a")) {
                            if (htmlTreeBuilder.getActiveFormattingElement("a") != null) {
                                htmlTreeBuilder.error(this);
                                htmlTreeBuilder.process(new Token.EndTag("a"));
                                Element fromStack = htmlTreeBuilder.getFromStack("a");
                                if (fromStack != null) {
                                    htmlTreeBuilder.removeFromActiveFormattingElements(fromStack);
                                    htmlTreeBuilder.removeFromStack(fromStack);
                                }
                            }
                            htmlTreeBuilder.reconstructFormattingElements();
                            htmlTreeBuilder.pushActiveFormattingElements(htmlTreeBuilder.insert(asStartTag));
                            break;
                        } else if (StringUtil.in(name, Constants.Formatters)) {
                            htmlTreeBuilder.reconstructFormattingElements();
                            htmlTreeBuilder.pushActiveFormattingElements(htmlTreeBuilder.insert(asStartTag));
                            break;
                        } else if (name.equals("nobr")) {
                            htmlTreeBuilder.reconstructFormattingElements();
                            if (htmlTreeBuilder.inScope("nobr")) {
                                htmlTreeBuilder.error(this);
                                htmlTreeBuilder.process(new Token.EndTag("nobr"));
                                htmlTreeBuilder.reconstructFormattingElements();
                            }
                            htmlTreeBuilder.pushActiveFormattingElements(htmlTreeBuilder.insert(asStartTag));
                            break;
                        } else if (StringUtil.in(name, Constants.InBodyStartApplets)) {
                            htmlTreeBuilder.reconstructFormattingElements();
                            htmlTreeBuilder.insert(asStartTag);
                            htmlTreeBuilder.insertMarkerToFormattingElements();
                            htmlTreeBuilder.framesetOk(false);
                            break;
                        } else if (name.equals("table")) {
                            if (htmlTreeBuilder.getDocument().quirksMode() != Document.QuirksMode.quirks && htmlTreeBuilder.inButtonScope("p")) {
                                htmlTreeBuilder.process(new Token.EndTag("p"));
                            }
                            htmlTreeBuilder.insert(asStartTag);
                            htmlTreeBuilder.framesetOk(false);
                            htmlTreeBuilder.transition(InTable);
                            break;
                        } else if (StringUtil.in(name, Constants.InBodyStartEmptyFormatters)) {
                            htmlTreeBuilder.reconstructFormattingElements();
                            htmlTreeBuilder.insertEmpty(asStartTag);
                            htmlTreeBuilder.framesetOk(false);
                            break;
                        } else if (name.equals("input")) {
                            htmlTreeBuilder.reconstructFormattingElements();
                            if (!htmlTreeBuilder.insertEmpty(asStartTag).attr("type").equalsIgnoreCase("hidden")) {
                                htmlTreeBuilder.framesetOk(false);
                                break;
                            }
                        } else if (StringUtil.in(name, Constants.InBodyStartMedia)) {
                            htmlTreeBuilder.insertEmpty(asStartTag);
                            break;
                        } else if (name.equals("hr")) {
                            if (htmlTreeBuilder.inButtonScope("p")) {
                                htmlTreeBuilder.process(new Token.EndTag("p"));
                            }
                            htmlTreeBuilder.insertEmpty(asStartTag);
                            htmlTreeBuilder.framesetOk(false);
                            break;
                        } else if (name.equals(TbConfig.TMP_PIC_DIR_NAME)) {
                            asStartTag.name("img");
                            return htmlTreeBuilder.process(asStartTag);
                        } else if (name.equals("isindex")) {
                            htmlTreeBuilder.error(this);
                            if (htmlTreeBuilder.getFormElement() != null) {
                                return false;
                            }
                            htmlTreeBuilder.tokeniser.acknowledgeSelfClosingFlag();
                            htmlTreeBuilder.process(new Token.StartTag("form"));
                            if (asStartTag.attributes.hasKey("action")) {
                                htmlTreeBuilder.getFormElement().attr("action", asStartTag.attributes.get("action"));
                            }
                            htmlTreeBuilder.process(new Token.StartTag("hr"));
                            htmlTreeBuilder.process(new Token.StartTag("label"));
                            htmlTreeBuilder.process(new Token.Character(asStartTag.attributes.hasKey("prompt") ? asStartTag.attributes.get("prompt") : "This is a searchable index. Enter search keywords: "));
                            Attributes attributes = new Attributes();
                            Iterator<Attribute> it3 = asStartTag.attributes.iterator();
                            while (it3.hasNext()) {
                                Attribute next3 = it3.next();
                                if (!StringUtil.in(next3.getKey(), Constants.InBodyStartInputAttribs)) {
                                    attributes.put(next3);
                                }
                            }
                            attributes.put("name", "isindex");
                            htmlTreeBuilder.process(new Token.StartTag("input", attributes));
                            htmlTreeBuilder.process(new Token.EndTag("label"));
                            htmlTreeBuilder.process(new Token.StartTag("hr"));
                            htmlTreeBuilder.process(new Token.EndTag("form"));
                            break;
                        } else if (name.equals("textarea")) {
                            htmlTreeBuilder.insert(asStartTag);
                            htmlTreeBuilder.tokeniser.transition(TokeniserState.Rcdata);
                            htmlTreeBuilder.markInsertionMode();
                            htmlTreeBuilder.framesetOk(false);
                            htmlTreeBuilder.transition(Text);
                            break;
                        } else if (name.equals("xmp")) {
                            if (htmlTreeBuilder.inButtonScope("p")) {
                                htmlTreeBuilder.process(new Token.EndTag("p"));
                            }
                            htmlTreeBuilder.reconstructFormattingElements();
                            htmlTreeBuilder.framesetOk(false);
                            HtmlTreeBuilderState.handleRawtext(asStartTag, htmlTreeBuilder);
                            break;
                        } else if (name.equals("iframe")) {
                            htmlTreeBuilder.framesetOk(false);
                            HtmlTreeBuilderState.handleRawtext(asStartTag, htmlTreeBuilder);
                            break;
                        } else if (name.equals("noembed")) {
                            HtmlTreeBuilderState.handleRawtext(asStartTag, htmlTreeBuilder);
                            break;
                        } else if (name.equals("select")) {
                            htmlTreeBuilder.reconstructFormattingElements();
                            htmlTreeBuilder.insert(asStartTag);
                            htmlTreeBuilder.framesetOk(false);
                            HtmlTreeBuilderState state = htmlTreeBuilder.state();
                            if (state.equals(InTable) || state.equals(InCaption) || state.equals(InTableBody) || state.equals(InRow) || state.equals(InCell)) {
                                htmlTreeBuilder.transition(InSelectInTable);
                                break;
                            } else {
                                htmlTreeBuilder.transition(InSelect);
                                break;
                            }
                        } else if (StringUtil.in(name, Constants.InBodyStartOptions)) {
                            if (htmlTreeBuilder.currentElement().nodeName().equals("option")) {
                                htmlTreeBuilder.process(new Token.EndTag("option"));
                            }
                            htmlTreeBuilder.reconstructFormattingElements();
                            htmlTreeBuilder.insert(asStartTag);
                            break;
                        } else if (StringUtil.in(name, Constants.InBodyStartRuby)) {
                            if (htmlTreeBuilder.inScope("ruby")) {
                                htmlTreeBuilder.generateImpliedEndTags();
                                if (!htmlTreeBuilder.currentElement().nodeName().equals("ruby")) {
                                    htmlTreeBuilder.error(this);
                                    htmlTreeBuilder.popStackToBefore("ruby");
                                }
                                htmlTreeBuilder.insert(asStartTag);
                                break;
                            }
                        } else if (name.equals("math")) {
                            htmlTreeBuilder.reconstructFormattingElements();
                            htmlTreeBuilder.insert(asStartTag);
                            htmlTreeBuilder.tokeniser.acknowledgeSelfClosingFlag();
                            break;
                        } else if (name.equals("svg")) {
                            htmlTreeBuilder.reconstructFormattingElements();
                            htmlTreeBuilder.insert(asStartTag);
                            htmlTreeBuilder.tokeniser.acknowledgeSelfClosingFlag();
                            break;
                        } else if (StringUtil.in(name, Constants.InBodyStartDrop)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        } else {
                            htmlTreeBuilder.reconstructFormattingElements();
                            htmlTreeBuilder.insert(asStartTag);
                            break;
                        }
                    }
                    break;
                case EndTag:
                    Token.EndTag asEndTag = token.asEndTag();
                    String name2 = asEndTag.name();
                    if (name2.equals("body")) {
                        if (!htmlTreeBuilder.inScope("body")) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.transition(AfterBody);
                        break;
                    } else if (name2.equals("html")) {
                        if (htmlTreeBuilder.process(new Token.EndTag("body"))) {
                            return htmlTreeBuilder.process(asEndTag);
                        }
                    } else if (StringUtil.in(name2, Constants.InBodyEndClosers)) {
                        if (!htmlTreeBuilder.inScope(name2)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.generateImpliedEndTags();
                        if (!htmlTreeBuilder.currentElement().nodeName().equals(name2)) {
                            htmlTreeBuilder.error(this);
                        }
                        htmlTreeBuilder.popStackToClose(name2);
                        break;
                    } else if (name2.equals("form")) {
                        FormElement formElement = htmlTreeBuilder.getFormElement();
                        htmlTreeBuilder.setFormElement(null);
                        if (formElement == null || !htmlTreeBuilder.inScope(name2)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.generateImpliedEndTags();
                        if (!htmlTreeBuilder.currentElement().nodeName().equals(name2)) {
                            htmlTreeBuilder.error(this);
                        }
                        htmlTreeBuilder.removeFromStack(formElement);
                        break;
                    } else if (name2.equals("p")) {
                        if (!htmlTreeBuilder.inButtonScope(name2)) {
                            htmlTreeBuilder.error(this);
                            htmlTreeBuilder.process(new Token.StartTag(name2));
                            return htmlTreeBuilder.process(asEndTag);
                        }
                        htmlTreeBuilder.generateImpliedEndTags(name2);
                        if (!htmlTreeBuilder.currentElement().nodeName().equals(name2)) {
                            htmlTreeBuilder.error(this);
                        }
                        htmlTreeBuilder.popStackToClose(name2);
                        break;
                    } else if (name2.equals("li")) {
                        if (!htmlTreeBuilder.inListItemScope(name2)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.generateImpliedEndTags(name2);
                        if (!htmlTreeBuilder.currentElement().nodeName().equals(name2)) {
                            htmlTreeBuilder.error(this);
                        }
                        htmlTreeBuilder.popStackToClose(name2);
                        break;
                    } else if (StringUtil.in(name2, Constants.DdDt)) {
                        if (!htmlTreeBuilder.inScope(name2)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.generateImpliedEndTags(name2);
                        if (!htmlTreeBuilder.currentElement().nodeName().equals(name2)) {
                            htmlTreeBuilder.error(this);
                        }
                        htmlTreeBuilder.popStackToClose(name2);
                        break;
                    } else if (!StringUtil.in(name2, Constants.Headings)) {
                        if (name2.equals("sarcasm")) {
                            return anyOtherEndTag(token, htmlTreeBuilder);
                        }
                        if (StringUtil.in(name2, Constants.InBodyEndAdoptionFormatters)) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= 8) {
                                    break;
                                } else {
                                    Element activeFormattingElement = htmlTreeBuilder.getActiveFormattingElement(name2);
                                    if (activeFormattingElement == null) {
                                        return anyOtherEndTag(token, htmlTreeBuilder);
                                    }
                                    if (!htmlTreeBuilder.onStack(activeFormattingElement)) {
                                        htmlTreeBuilder.error(this);
                                        htmlTreeBuilder.removeFromActiveFormattingElements(activeFormattingElement);
                                        return true;
                                    } else if (!htmlTreeBuilder.inScope(activeFormattingElement.nodeName())) {
                                        htmlTreeBuilder.error(this);
                                        return false;
                                    } else {
                                        if (htmlTreeBuilder.currentElement() != activeFormattingElement) {
                                            htmlTreeBuilder.error(this);
                                        }
                                        Element element8 = null;
                                        Element element9 = null;
                                        boolean z2 = false;
                                        DescendableLinkedList<Element> stack5 = htmlTreeBuilder.getStack();
                                        int size3 = stack5.size();
                                        int i3 = 0;
                                        while (true) {
                                            if (i3 < size3 && i3 < 64) {
                                                Element element10 = stack5.get(i3);
                                                if (element10 == activeFormattingElement) {
                                                    element3 = stack5.get(i3 - 1);
                                                    z = true;
                                                } else if (z2 && htmlTreeBuilder.isSpecial(element10)) {
                                                    element8 = element10;
                                                } else {
                                                    z = z2;
                                                    element3 = element9;
                                                }
                                                i3++;
                                                element9 = element3;
                                                z2 = z;
                                            }
                                        }
                                        if (element8 == null) {
                                            htmlTreeBuilder.popStackToClose(activeFormattingElement.nodeName());
                                            htmlTreeBuilder.removeFromActiveFormattingElements(activeFormattingElement);
                                            return true;
                                        }
                                        int i4 = 0;
                                        Element element11 = element8;
                                        Element element12 = element8;
                                        while (i4 < 3) {
                                            if (htmlTreeBuilder.onStack(element12)) {
                                                element12 = htmlTreeBuilder.aboveOnStack(element12);
                                            }
                                            if (!htmlTreeBuilder.isInActiveFormattingElements(element12)) {
                                                htmlTreeBuilder.removeFromStack(element12);
                                                element = element12;
                                                element2 = element11;
                                            } else if (element12 != activeFormattingElement) {
                                                element = new Element(Tag.valueOf(element12.nodeName()), htmlTreeBuilder.getBaseUri());
                                                htmlTreeBuilder.replaceActiveFormattingElement(element12, element);
                                                htmlTreeBuilder.replaceOnStack(element12, element);
                                                if (element11 == element8) {
                                                }
                                                if (element11.parent() != null) {
                                                    element11.remove();
                                                }
                                                element.appendChild(element11);
                                                element2 = element;
                                            } else {
                                                if (!StringUtil.in(element9.nodeName(), Constants.InBodyEndTableFosters)) {
                                                    if (element11.parent() != null) {
                                                        element11.remove();
                                                    }
                                                    htmlTreeBuilder.insertInFosterParent(element11);
                                                } else {
                                                    if (element11.parent() != null) {
                                                        element11.remove();
                                                    }
                                                    element9.appendChild(element11);
                                                }
                                                Element element13 = new Element(activeFormattingElement.tag(), htmlTreeBuilder.getBaseUri());
                                                element13.attributes().addAll(activeFormattingElement.attributes());
                                                for (Node node : (Node[]) element8.childNodes().toArray(new Node[element8.childNodeSize()])) {
                                                    element13.appendChild(node);
                                                }
                                                element8.appendChild(element13);
                                                htmlTreeBuilder.removeFromActiveFormattingElements(activeFormattingElement);
                                                htmlTreeBuilder.removeFromStack(activeFormattingElement);
                                                htmlTreeBuilder.insertOnStackAfter(element8, element13);
                                                i = i2 + 1;
                                            }
                                            i4++;
                                            element11 = element2;
                                            element12 = element;
                                        }
                                        if (!StringUtil.in(element9.nodeName(), Constants.InBodyEndTableFosters)) {
                                        }
                                        Element element132 = new Element(activeFormattingElement.tag(), htmlTreeBuilder.getBaseUri());
                                        element132.attributes().addAll(activeFormattingElement.attributes());
                                        while (r1 < r3) {
                                        }
                                        element8.appendChild(element132);
                                        htmlTreeBuilder.removeFromActiveFormattingElements(activeFormattingElement);
                                        htmlTreeBuilder.removeFromStack(activeFormattingElement);
                                        htmlTreeBuilder.insertOnStackAfter(element8, element132);
                                        i = i2 + 1;
                                    }
                                }
                            }
                        } else if (StringUtil.in(name2, Constants.InBodyStartApplets)) {
                            if (!htmlTreeBuilder.inScope("name")) {
                                if (!htmlTreeBuilder.inScope(name2)) {
                                    htmlTreeBuilder.error(this);
                                    return false;
                                }
                                htmlTreeBuilder.generateImpliedEndTags();
                                if (!htmlTreeBuilder.currentElement().nodeName().equals(name2)) {
                                    htmlTreeBuilder.error(this);
                                }
                                htmlTreeBuilder.popStackToClose(name2);
                                htmlTreeBuilder.clearFormattingElementsToLastMarker();
                                break;
                            }
                        } else if (name2.equals("br")) {
                            htmlTreeBuilder.error(this);
                            htmlTreeBuilder.process(new Token.StartTag("br"));
                            return false;
                        } else {
                            return anyOtherEndTag(token, htmlTreeBuilder);
                        }
                    } else if (!htmlTreeBuilder.inScope(Constants.Headings)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    } else {
                        htmlTreeBuilder.generateImpliedEndTags(name2);
                        if (!htmlTreeBuilder.currentElement().nodeName().equals(name2)) {
                            htmlTreeBuilder.error(this);
                        }
                        htmlTreeBuilder.popStackToClose(Constants.Headings);
                        break;
                    }
                    break;
                case Character:
                    Token.Character asCharacter = token.asCharacter();
                    if (!asCharacter.getData().equals(HtmlTreeBuilderState.nullString)) {
                        if (HtmlTreeBuilderState.isWhitespace(asCharacter)) {
                            htmlTreeBuilder.reconstructFormattingElements();
                            htmlTreeBuilder.insert(asCharacter);
                            break;
                        } else {
                            htmlTreeBuilder.reconstructFormattingElements();
                            htmlTreeBuilder.insert(asCharacter);
                            htmlTreeBuilder.framesetOk(false);
                            break;
                        }
                    } else {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
            }
            return true;
        }

        boolean anyOtherEndTag(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            Element next;
            String name = token.asEndTag().name();
            Iterator<Element> descendingIterator = htmlTreeBuilder.getStack().descendingIterator();
            do {
                if (descendingIterator.hasNext()) {
                    next = descendingIterator.next();
                    if (next.nodeName().equals(name)) {
                        htmlTreeBuilder.generateImpliedEndTags(name);
                        if (!name.equals(htmlTreeBuilder.currentElement().nodeName())) {
                            htmlTreeBuilder.error(this);
                        }
                        htmlTreeBuilder.popStackToClose(name);
                    }
                }
                return true;
            } while (!htmlTreeBuilder.isSpecial(next));
            htmlTreeBuilder.error(this);
            return false;
        }
    },
    Text { // from class: org.jsoup.parser.HtmlTreeBuilderState.8
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isCharacter()) {
                htmlTreeBuilder.insert(token.asCharacter());
            } else if (token.isEOF()) {
                htmlTreeBuilder.error(this);
                htmlTreeBuilder.pop();
                htmlTreeBuilder.transition(htmlTreeBuilder.originalState());
                return htmlTreeBuilder.process(token);
            } else if (token.isEndTag()) {
                htmlTreeBuilder.pop();
                htmlTreeBuilder.transition(htmlTreeBuilder.originalState());
            }
            return true;
        }
    },
    InTable { // from class: org.jsoup.parser.HtmlTreeBuilderState.9
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isCharacter()) {
                htmlTreeBuilder.newPendingTableCharacters();
                htmlTreeBuilder.markInsertionMode();
                htmlTreeBuilder.transition(InTableText);
                return htmlTreeBuilder.process(token);
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (token.isStartTag()) {
                Token.StartTag asStartTag = token.asStartTag();
                String name = asStartTag.name();
                if (name.equals("caption")) {
                    htmlTreeBuilder.clearStackToTableContext();
                    htmlTreeBuilder.insertMarkerToFormattingElements();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(InCaption);
                    return true;
                } else if (name.equals("colgroup")) {
                    htmlTreeBuilder.clearStackToTableContext();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(InColumnGroup);
                    return true;
                } else if (name.equals("col")) {
                    htmlTreeBuilder.process(new Token.StartTag("colgroup"));
                    return htmlTreeBuilder.process(token);
                } else if (StringUtil.in(name, "tbody", "tfoot", "thead")) {
                    htmlTreeBuilder.clearStackToTableContext();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(InTableBody);
                    return true;
                } else if (StringUtil.in(name, "td", "th", "tr")) {
                    htmlTreeBuilder.process(new Token.StartTag("tbody"));
                    return htmlTreeBuilder.process(token);
                } else if (name.equals("table")) {
                    htmlTreeBuilder.error(this);
                    if (htmlTreeBuilder.process(new Token.EndTag("table"))) {
                        return htmlTreeBuilder.process(token);
                    }
                    return true;
                } else if (StringUtil.in(name, "style", "script")) {
                    return htmlTreeBuilder.process(token, InHead);
                } else {
                    if (name.equals("input")) {
                        if (!asStartTag.attributes.get("type").equalsIgnoreCase("hidden")) {
                            return anythingElse(token, htmlTreeBuilder);
                        }
                        htmlTreeBuilder.insertEmpty(asStartTag);
                        return true;
                    } else if (name.equals("form")) {
                        htmlTreeBuilder.error(this);
                        if (htmlTreeBuilder.getFormElement() != null) {
                            return false;
                        }
                        htmlTreeBuilder.insertForm(asStartTag, false);
                        return true;
                    } else {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                }
            } else if (token.isEndTag()) {
                String name2 = token.asEndTag().name();
                if (!name2.equals("table")) {
                    if (StringUtil.in(name2, "body", "caption", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr")) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    return anythingElse(token, htmlTreeBuilder);
                } else if (!htmlTreeBuilder.inTableScope(name2)) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else {
                    htmlTreeBuilder.popStackToClose("table");
                    htmlTreeBuilder.resetInsertionMode();
                    return true;
                }
            } else if (token.isEOF()) {
                if (htmlTreeBuilder.currentElement().nodeName().equals("html")) {
                    htmlTreeBuilder.error(this);
                    return true;
                }
                return true;
            } else {
                return anythingElse(token, htmlTreeBuilder);
            }
        }

        boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.error(this);
            if (StringUtil.in(htmlTreeBuilder.currentElement().nodeName(), "table", "tbody", "tfoot", "thead", "tr")) {
                htmlTreeBuilder.setFosterInserts(true);
                boolean process = htmlTreeBuilder.process(token, InBody);
                htmlTreeBuilder.setFosterInserts(false);
                return process;
            }
            return htmlTreeBuilder.process(token, InBody);
        }
    },
    InTableText { // from class: org.jsoup.parser.HtmlTreeBuilderState.10
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            switch (AnonymousClass24.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()]) {
                case 5:
                    Token.Character asCharacter = token.asCharacter();
                    if (asCharacter.getData().equals(HtmlTreeBuilderState.nullString)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.getPendingTableCharacters().add(asCharacter);
                    return true;
                default:
                    if (htmlTreeBuilder.getPendingTableCharacters().size() > 0) {
                        for (Token.Character character : htmlTreeBuilder.getPendingTableCharacters()) {
                            if (!HtmlTreeBuilderState.isWhitespace(character)) {
                                htmlTreeBuilder.error(this);
                                if (StringUtil.in(htmlTreeBuilder.currentElement().nodeName(), "table", "tbody", "tfoot", "thead", "tr")) {
                                    htmlTreeBuilder.setFosterInserts(true);
                                    htmlTreeBuilder.process(character, InBody);
                                    htmlTreeBuilder.setFosterInserts(false);
                                } else {
                                    htmlTreeBuilder.process(character, InBody);
                                }
                            } else {
                                htmlTreeBuilder.insert(character);
                            }
                        }
                        htmlTreeBuilder.newPendingTableCharacters();
                    }
                    htmlTreeBuilder.transition(htmlTreeBuilder.originalState());
                    return htmlTreeBuilder.process(token);
            }
        }
    },
    InCaption { // from class: org.jsoup.parser.HtmlTreeBuilderState.11
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isEndTag() && token.asEndTag().name().equals("caption")) {
                if (!htmlTreeBuilder.inTableScope(token.asEndTag().name())) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.generateImpliedEndTags();
                if (!htmlTreeBuilder.currentElement().nodeName().equals("caption")) {
                    htmlTreeBuilder.error(this);
                }
                htmlTreeBuilder.popStackToClose("caption");
                htmlTreeBuilder.clearFormattingElementsToLastMarker();
                htmlTreeBuilder.transition(InTable);
            } else if ((token.isStartTag() && StringUtil.in(token.asStartTag().name(), "caption", "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr")) || (token.isEndTag() && token.asEndTag().name().equals("table"))) {
                htmlTreeBuilder.error(this);
                if (htmlTreeBuilder.process(new Token.EndTag("caption"))) {
                    return htmlTreeBuilder.process(token);
                }
            } else if (token.isEndTag() && StringUtil.in(token.asEndTag().name(), "body", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr")) {
                htmlTreeBuilder.error(this);
                return false;
            } else {
                return htmlTreeBuilder.process(token, InBody);
            }
            return true;
        }
    },
    InColumnGroup { // from class: org.jsoup.parser.HtmlTreeBuilderState.12
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            switch (AnonymousClass24.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()]) {
                case 1:
                    htmlTreeBuilder.insert(token.asComment());
                    return true;
                case 2:
                    htmlTreeBuilder.error(this);
                    return true;
                case 3:
                    Token.StartTag asStartTag = token.asStartTag();
                    String name = asStartTag.name();
                    if (name.equals("html")) {
                        return htmlTreeBuilder.process(token, InBody);
                    }
                    if (name.equals("col")) {
                        htmlTreeBuilder.insertEmpty(asStartTag);
                        return true;
                    }
                    return anythingElse(token, htmlTreeBuilder);
                case 4:
                    if (token.asEndTag().name().equals("colgroup")) {
                        if (htmlTreeBuilder.currentElement().nodeName().equals("html")) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.pop();
                        htmlTreeBuilder.transition(InTable);
                        return true;
                    }
                    return anythingElse(token, htmlTreeBuilder);
                case 5:
                default:
                    return anythingElse(token, htmlTreeBuilder);
                case 6:
                    if (htmlTreeBuilder.currentElement().nodeName().equals("html")) {
                        return true;
                    }
                    return anythingElse(token, htmlTreeBuilder);
            }
        }

        private boolean anythingElse(Token token, TreeBuilder treeBuilder) {
            if (treeBuilder.process(new Token.EndTag("colgroup"))) {
                return treeBuilder.process(token);
            }
            return true;
        }
    },
    InTableBody { // from class: org.jsoup.parser.HtmlTreeBuilderState.13
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            switch (AnonymousClass24.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()]) {
                case 3:
                    Token.StartTag asStartTag = token.asStartTag();
                    String name = asStartTag.name();
                    if (!name.equals("tr")) {
                        if (StringUtil.in(name, "th", "td")) {
                            htmlTreeBuilder.error(this);
                            htmlTreeBuilder.process(new Token.StartTag("tr"));
                            return htmlTreeBuilder.process(asStartTag);
                        } else if (StringUtil.in(name, "caption", "col", "colgroup", "tbody", "tfoot", "thead")) {
                            return exitTableBody(token, htmlTreeBuilder);
                        } else {
                            return anythingElse(token, htmlTreeBuilder);
                        }
                    }
                    htmlTreeBuilder.clearStackToTableBodyContext();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(InRow);
                    break;
                case 4:
                    String name2 = token.asEndTag().name();
                    if (StringUtil.in(name2, "tbody", "tfoot", "thead")) {
                        if (!htmlTreeBuilder.inTableScope(name2)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.clearStackToTableBodyContext();
                        htmlTreeBuilder.pop();
                        htmlTreeBuilder.transition(InTable);
                        break;
                    } else if (name2.equals("table")) {
                        return exitTableBody(token, htmlTreeBuilder);
                    } else {
                        if (StringUtil.in(name2, "body", "caption", "col", "colgroup", "html", "td", "th", "tr")) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        return anythingElse(token, htmlTreeBuilder);
                    }
                default:
                    return anythingElse(token, htmlTreeBuilder);
            }
            return true;
        }

        private boolean exitTableBody(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (!htmlTreeBuilder.inTableScope("tbody") && !htmlTreeBuilder.inTableScope("thead") && !htmlTreeBuilder.inScope("tfoot")) {
                htmlTreeBuilder.error(this);
                return false;
            }
            htmlTreeBuilder.clearStackToTableBodyContext();
            htmlTreeBuilder.process(new Token.EndTag(htmlTreeBuilder.currentElement().nodeName()));
            return htmlTreeBuilder.process(token);
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.process(token, InTable);
        }
    },
    InRow { // from class: org.jsoup.parser.HtmlTreeBuilderState.14
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isStartTag()) {
                Token.StartTag asStartTag = token.asStartTag();
                String name = asStartTag.name();
                if (!StringUtil.in(name, "th", "td")) {
                    if (StringUtil.in(name, "caption", "col", "colgroup", "tbody", "tfoot", "thead", "tr")) {
                        return handleMissingTr(token, htmlTreeBuilder);
                    }
                    return anythingElse(token, htmlTreeBuilder);
                }
                htmlTreeBuilder.clearStackToTableRowContext();
                htmlTreeBuilder.insert(asStartTag);
                htmlTreeBuilder.transition(InCell);
                htmlTreeBuilder.insertMarkerToFormattingElements();
            } else if (token.isEndTag()) {
                String name2 = token.asEndTag().name();
                if (name2.equals("tr")) {
                    if (!htmlTreeBuilder.inTableScope(name2)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.clearStackToTableRowContext();
                    htmlTreeBuilder.pop();
                    htmlTreeBuilder.transition(InTableBody);
                } else if (name2.equals("table")) {
                    return handleMissingTr(token, htmlTreeBuilder);
                } else {
                    if (!StringUtil.in(name2, "tbody", "tfoot", "thead")) {
                        if (StringUtil.in(name2, "body", "caption", "col", "colgroup", "html", "td", "th")) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        return anythingElse(token, htmlTreeBuilder);
                    } else if (!htmlTreeBuilder.inTableScope(name2)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    } else {
                        htmlTreeBuilder.process(new Token.EndTag("tr"));
                        return htmlTreeBuilder.process(token);
                    }
                }
            } else {
                return anythingElse(token, htmlTreeBuilder);
            }
            return true;
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.process(token, InTable);
        }

        private boolean handleMissingTr(Token token, TreeBuilder treeBuilder) {
            if (treeBuilder.process(new Token.EndTag("tr"))) {
                return treeBuilder.process(token);
            }
            return false;
        }
    },
    InCell { // from class: org.jsoup.parser.HtmlTreeBuilderState.15
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isEndTag()) {
                String name = token.asEndTag().name();
                if (!StringUtil.in(name, "td", "th")) {
                    if (StringUtil.in(name, "body", "caption", "col", "colgroup", "html")) {
                        htmlTreeBuilder.error(this);
                        return false;
                    } else if (StringUtil.in(name, "table", "tbody", "tfoot", "thead", "tr")) {
                        if (!htmlTreeBuilder.inTableScope(name)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        closeCell(htmlTreeBuilder);
                        return htmlTreeBuilder.process(token);
                    } else {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                } else if (!htmlTreeBuilder.inTableScope(name)) {
                    htmlTreeBuilder.error(this);
                    htmlTreeBuilder.transition(InRow);
                    return false;
                } else {
                    htmlTreeBuilder.generateImpliedEndTags();
                    if (!htmlTreeBuilder.currentElement().nodeName().equals(name)) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(name);
                    htmlTreeBuilder.clearFormattingElementsToLastMarker();
                    htmlTreeBuilder.transition(InRow);
                    return true;
                }
            } else if (token.isStartTag() && StringUtil.in(token.asStartTag().name(), "caption", "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr")) {
                if (!htmlTreeBuilder.inTableScope("td") && !htmlTreeBuilder.inTableScope("th")) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                closeCell(htmlTreeBuilder);
                return htmlTreeBuilder.process(token);
            } else {
                return anythingElse(token, htmlTreeBuilder);
            }
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.process(token, InBody);
        }

        private void closeCell(HtmlTreeBuilder htmlTreeBuilder) {
            if (htmlTreeBuilder.inTableScope("td")) {
                htmlTreeBuilder.process(new Token.EndTag("td"));
            } else {
                htmlTreeBuilder.process(new Token.EndTag("th"));
            }
        }
    },
    InSelect { // from class: org.jsoup.parser.HtmlTreeBuilderState.16
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            switch (AnonymousClass24.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()]) {
                case 1:
                    htmlTreeBuilder.insert(token.asComment());
                    break;
                case 2:
                    htmlTreeBuilder.error(this);
                    return false;
                case 3:
                    Token.StartTag asStartTag = token.asStartTag();
                    String name = asStartTag.name();
                    if (name.equals("html")) {
                        return htmlTreeBuilder.process(asStartTag, InBody);
                    }
                    if (name.equals("option")) {
                        htmlTreeBuilder.process(new Token.EndTag("option"));
                        htmlTreeBuilder.insert(asStartTag);
                        break;
                    } else if (name.equals("optgroup")) {
                        if (htmlTreeBuilder.currentElement().nodeName().equals("option")) {
                            htmlTreeBuilder.process(new Token.EndTag("option"));
                        } else if (htmlTreeBuilder.currentElement().nodeName().equals("optgroup")) {
                            htmlTreeBuilder.process(new Token.EndTag("optgroup"));
                        }
                        htmlTreeBuilder.insert(asStartTag);
                        break;
                    } else if (name.equals("select")) {
                        htmlTreeBuilder.error(this);
                        return htmlTreeBuilder.process(new Token.EndTag("select"));
                    } else if (StringUtil.in(name, "input", "keygen", "textarea")) {
                        htmlTreeBuilder.error(this);
                        if (htmlTreeBuilder.inSelectScope("select")) {
                            htmlTreeBuilder.process(new Token.EndTag("select"));
                            return htmlTreeBuilder.process(asStartTag);
                        }
                        return false;
                    } else if (name.equals("script")) {
                        return htmlTreeBuilder.process(token, InHead);
                    } else {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                case 4:
                    String name2 = token.asEndTag().name();
                    if (name2.equals("optgroup")) {
                        if (htmlTreeBuilder.currentElement().nodeName().equals("option") && htmlTreeBuilder.aboveOnStack(htmlTreeBuilder.currentElement()) != null && htmlTreeBuilder.aboveOnStack(htmlTreeBuilder.currentElement()).nodeName().equals("optgroup")) {
                            htmlTreeBuilder.process(new Token.EndTag("option"));
                        }
                        if (htmlTreeBuilder.currentElement().nodeName().equals("optgroup")) {
                            htmlTreeBuilder.pop();
                            break;
                        } else {
                            htmlTreeBuilder.error(this);
                            break;
                        }
                    } else if (name2.equals("option")) {
                        if (htmlTreeBuilder.currentElement().nodeName().equals("option")) {
                            htmlTreeBuilder.pop();
                            break;
                        } else {
                            htmlTreeBuilder.error(this);
                            break;
                        }
                    } else if (name2.equals("select")) {
                        if (!htmlTreeBuilder.inSelectScope(name2)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.popStackToClose(name2);
                        htmlTreeBuilder.resetInsertionMode();
                        break;
                    } else {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    break;
                case 5:
                    Token.Character asCharacter = token.asCharacter();
                    if (asCharacter.getData().equals(HtmlTreeBuilderState.nullString)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.insert(asCharacter);
                    break;
                case 6:
                    if (!htmlTreeBuilder.currentElement().nodeName().equals("html")) {
                        htmlTreeBuilder.error(this);
                        break;
                    }
                    break;
                default:
                    return anythingElse(token, htmlTreeBuilder);
            }
            return true;
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.error(this);
            return false;
        }
    },
    InSelectInTable { // from class: org.jsoup.parser.HtmlTreeBuilderState.17
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isStartTag() && StringUtil.in(token.asStartTag().name(), "caption", "table", "tbody", "tfoot", "thead", "tr", "td", "th")) {
                htmlTreeBuilder.error(this);
                htmlTreeBuilder.process(new Token.EndTag("select"));
                return htmlTreeBuilder.process(token);
            } else if (token.isEndTag() && StringUtil.in(token.asEndTag().name(), "caption", "table", "tbody", "tfoot", "thead", "tr", "td", "th")) {
                htmlTreeBuilder.error(this);
                if (htmlTreeBuilder.inTableScope(token.asEndTag().name())) {
                    htmlTreeBuilder.process(new Token.EndTag("select"));
                    return htmlTreeBuilder.process(token);
                }
                return false;
            } else {
                return htmlTreeBuilder.process(token, InSelect);
            }
        }
    },
    AfterBody { // from class: org.jsoup.parser.HtmlTreeBuilderState.18
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                return htmlTreeBuilder.process(token, InBody);
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (token.isStartTag() && token.asStartTag().name().equals("html")) {
                return htmlTreeBuilder.process(token, InBody);
            } else {
                if (token.isEndTag() && token.asEndTag().name().equals("html")) {
                    if (htmlTreeBuilder.isFragmentParsing()) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.transition(AfterAfterBody);
                } else if (!token.isEOF()) {
                    htmlTreeBuilder.error(this);
                    htmlTreeBuilder.transition(InBody);
                    return htmlTreeBuilder.process(token);
                }
            }
            return true;
        }
    },
    InFrameset { // from class: org.jsoup.parser.HtmlTreeBuilderState.19
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (token.isStartTag()) {
                Token.StartTag asStartTag = token.asStartTag();
                String name = asStartTag.name();
                if (name.equals("html")) {
                    return htmlTreeBuilder.process(asStartTag, InBody);
                }
                if (name.equals("frameset")) {
                    htmlTreeBuilder.insert(asStartTag);
                } else if (name.equals("frame")) {
                    htmlTreeBuilder.insertEmpty(asStartTag);
                } else if (name.equals("noframes")) {
                    return htmlTreeBuilder.process(asStartTag, InHead);
                } else {
                    htmlTreeBuilder.error(this);
                    return false;
                }
            } else if (token.isEndTag() && token.asEndTag().name().equals("frameset")) {
                if (htmlTreeBuilder.currentElement().nodeName().equals("html")) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.pop();
                if (!htmlTreeBuilder.isFragmentParsing() && !htmlTreeBuilder.currentElement().nodeName().equals("frameset")) {
                    htmlTreeBuilder.transition(AfterFrameset);
                }
            } else if (token.isEOF()) {
                if (!htmlTreeBuilder.currentElement().nodeName().equals("html")) {
                    htmlTreeBuilder.error(this);
                    return true;
                }
            } else {
                htmlTreeBuilder.error(this);
                return false;
            }
            return true;
        }
    },
    AfterFrameset { // from class: org.jsoup.parser.HtmlTreeBuilderState.20
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (token.isStartTag() && token.asStartTag().name().equals("html")) {
                return htmlTreeBuilder.process(token, InBody);
            } else {
                if (token.isEndTag() && token.asEndTag().name().equals("html")) {
                    htmlTreeBuilder.transition(AfterAfterFrameset);
                } else if (token.isStartTag() && token.asStartTag().name().equals("noframes")) {
                    return htmlTreeBuilder.process(token, InHead);
                } else {
                    if (!token.isEOF()) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                }
            }
            return true;
        }
    },
    AfterAfterBody { // from class: org.jsoup.parser.HtmlTreeBuilderState.21
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (token.isDoctype() || HtmlTreeBuilderState.isWhitespace(token) || (token.isStartTag() && token.asStartTag().name().equals("html"))) {
                return htmlTreeBuilder.process(token, InBody);
            } else {
                if (!token.isEOF()) {
                    htmlTreeBuilder.error(this);
                    htmlTreeBuilder.transition(InBody);
                    return htmlTreeBuilder.process(token);
                }
            }
            return true;
        }
    },
    AfterAfterFrameset { // from class: org.jsoup.parser.HtmlTreeBuilderState.22
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (token.isDoctype() || HtmlTreeBuilderState.isWhitespace(token) || (token.isStartTag() && token.asStartTag().name().equals("html"))) {
                return htmlTreeBuilder.process(token, InBody);
            } else {
                if (!token.isEOF()) {
                    if (token.isStartTag() && token.asStartTag().name().equals("noframes")) {
                        return htmlTreeBuilder.process(token, InHead);
                    }
                    htmlTreeBuilder.error(this);
                    return false;
                }
            }
            return true;
        }
    },
    ForeignContent { // from class: org.jsoup.parser.HtmlTreeBuilderState.23
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return true;
        }
    };
    
    private static String nullString = String.valueOf((char) 0);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder);

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isWhitespace(Token token) {
        if (token.isCharacter()) {
            String data = token.asCharacter().getData();
            for (int i = 0; i < data.length(); i++) {
                if (!StringUtil.isWhitespace(data.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleRcData(Token.StartTag startTag, HtmlTreeBuilder htmlTreeBuilder) {
        htmlTreeBuilder.insert(startTag);
        htmlTreeBuilder.tokeniser.transition(TokeniserState.Rcdata);
        htmlTreeBuilder.markInsertionMode();
        htmlTreeBuilder.transition(Text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleRawtext(Token.StartTag startTag, HtmlTreeBuilder htmlTreeBuilder) {
        htmlTreeBuilder.insert(startTag);
        htmlTreeBuilder.tokeniser.transition(TokeniserState.Rawtext);
        htmlTreeBuilder.markInsertionMode();
        htmlTreeBuilder.transition(Text);
    }

    /* loaded from: classes.dex */
    final class Constants {
        private static final String[] InBodyStartToHead = {"base", "basefont", "bgsound", "command", "link", "meta", "noframes", "script", "style", "title"};
        private static final String[] InBodyStartPClosers = {"address", "article", "aside", "blockquote", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "menu", "nav", "ol", "p", "section", "summary", "ul"};
        private static final String[] Headings = {"h1", "h2", "h3", "h4", "h5", "h6"};
        private static final String[] InBodyStartPreListing = {"pre", "listing"};
        private static final String[] InBodyStartLiBreakers = {"address", "div", "p"};
        private static final String[] DdDt = {"dd", "dt"};
        private static final String[] Formatters = {"b", "big", "code", "em", "font", "i", "s", "small", "strike", "strong", "tt", "u"};
        private static final String[] InBodyStartApplets = {"applet", "marquee", "object"};
        private static final String[] InBodyStartEmptyFormatters = {"area", "br", "embed", "img", "keygen", "wbr"};
        private static final String[] InBodyStartMedia = {"param", "source", "track"};
        private static final String[] InBodyStartInputAttribs = {"name", "action", "prompt"};
        private static final String[] InBodyStartOptions = {"optgroup", "option"};
        private static final String[] InBodyStartRuby = {"rp", "rt"};
        private static final String[] InBodyStartDrop = {"caption", "col", "colgroup", "frame", "head", "tbody", "td", "tfoot", "th", "thead", "tr"};
        private static final String[] InBodyEndClosers = {"address", "article", "aside", "blockquote", "button", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "listing", "menu", "nav", "ol", "pre", "section", "summary", "ul"};
        private static final String[] InBodyEndAdoptionFormatters = {"a", "b", "big", "code", "em", "font", "i", "nobr", "s", "small", "strike", "strong", "tt", "u"};
        private static final String[] InBodyEndTableFosters = {"table", "tbody", "tfoot", "thead", "tr"};

        private Constants() {
        }
    }
}
