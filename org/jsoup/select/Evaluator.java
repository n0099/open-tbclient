package org.jsoup.select;

import java.util.List;
import java.util.regex.Pattern;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.XmlDeclaration;
/* loaded from: classes.dex */
public abstract class Evaluator {
    public abstract boolean matches(Element element, Element element2);

    /* loaded from: classes.dex */
    public final class Tag extends Evaluator {
        private String tagName;

        public Tag(String str) {
            this.tagName = str;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.tagName().equals(this.tagName);
        }

        public String toString() {
            return String.format("%s", this.tagName);
        }
    }

    /* loaded from: classes.dex */
    public final class Id extends Evaluator {
        private String id;

        public Id(String str) {
            this.id = str;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return this.id.equals(element2.id());
        }

        public String toString() {
            return String.format("#%s", this.id);
        }
    }

    /* loaded from: classes.dex */
    public final class Class extends Evaluator {
        private String className;

        public Class(String str) {
            this.className = str;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.hasClass(this.className);
        }

        public String toString() {
            return String.format(".%s", this.className);
        }
    }

    /* loaded from: classes.dex */
    public final class Attribute extends Evaluator {
        private String key;

        public Attribute(String str) {
            this.key = str;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.hasAttr(this.key);
        }

        public String toString() {
            return String.format("[%s]", this.key);
        }
    }

    /* loaded from: classes.dex */
    public final class AttributeStarting extends Evaluator {
        private String keyPrefix;

        public AttributeStarting(String str) {
            this.keyPrefix = str;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            for (org.jsoup.nodes.Attribute attribute : element2.attributes().asList()) {
                if (attribute.getKey().startsWith(this.keyPrefix)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format("[^%s]", this.keyPrefix);
        }
    }

    /* loaded from: classes.dex */
    public final class AttributeWithValue extends AttributeKeyPair {
        public AttributeWithValue(String str, String str2) {
            super(str, str2);
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.hasAttr(this.key) && this.value.equalsIgnoreCase(element2.attr(this.key));
        }

        public String toString() {
            return String.format("[%s=%s]", this.key, this.value);
        }
    }

    /* loaded from: classes.dex */
    public final class AttributeWithValueNot extends AttributeKeyPair {
        public AttributeWithValueNot(String str, String str2) {
            super(str, str2);
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return !this.value.equalsIgnoreCase(element2.attr(this.key));
        }

        public String toString() {
            return String.format("[%s!=%s]", this.key, this.value);
        }
    }

    /* loaded from: classes.dex */
    public final class AttributeWithValueStarting extends AttributeKeyPair {
        public AttributeWithValueStarting(String str, String str2) {
            super(str, str2);
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.hasAttr(this.key) && element2.attr(this.key).toLowerCase().startsWith(this.value);
        }

        public String toString() {
            return String.format("[%s^=%s]", this.key, this.value);
        }
    }

    /* loaded from: classes.dex */
    public final class AttributeWithValueEnding extends AttributeKeyPair {
        public AttributeWithValueEnding(String str, String str2) {
            super(str, str2);
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.hasAttr(this.key) && element2.attr(this.key).toLowerCase().endsWith(this.value);
        }

        public String toString() {
            return String.format("[%s$=%s]", this.key, this.value);
        }
    }

    /* loaded from: classes.dex */
    public final class AttributeWithValueContaining extends AttributeKeyPair {
        public AttributeWithValueContaining(String str, String str2) {
            super(str, str2);
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.hasAttr(this.key) && element2.attr(this.key).toLowerCase().contains(this.value);
        }

        public String toString() {
            return String.format("[%s*=%s]", this.key, this.value);
        }
    }

    /* loaded from: classes.dex */
    public final class AttributeWithValueMatching extends Evaluator {
        String key;
        Pattern pattern;

        public AttributeWithValueMatching(String str, Pattern pattern) {
            this.key = str.trim().toLowerCase();
            this.pattern = pattern;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.hasAttr(this.key) && this.pattern.matcher(element2.attr(this.key)).find();
        }

        public String toString() {
            return String.format("[%s~=%s]", this.key, this.pattern.toString());
        }
    }

    /* loaded from: classes.dex */
    public abstract class AttributeKeyPair extends Evaluator {
        String key;
        String value;

        public AttributeKeyPair(String str, String str2) {
            Validate.notEmpty(str);
            Validate.notEmpty(str2);
            this.key = str.trim().toLowerCase();
            this.value = str2.trim().toLowerCase();
        }
    }

    /* loaded from: classes.dex */
    public final class AllElements extends Evaluator {
        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return true;
        }

        public String toString() {
            return "*";
        }
    }

    /* loaded from: classes.dex */
    public final class IndexLessThan extends IndexEvaluator {
        public IndexLessThan(int i) {
            super(i);
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.elementSiblingIndex().intValue() < this.index;
        }

        public String toString() {
            return String.format(":lt(%d)", Integer.valueOf(this.index));
        }
    }

    /* loaded from: classes.dex */
    public final class IndexGreaterThan extends IndexEvaluator {
        public IndexGreaterThan(int i) {
            super(i);
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.elementSiblingIndex().intValue() > this.index;
        }

        public String toString() {
            return String.format(":gt(%d)", Integer.valueOf(this.index));
        }
    }

    /* loaded from: classes.dex */
    public final class IndexEquals extends IndexEvaluator {
        public IndexEquals(int i) {
            super(i);
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.elementSiblingIndex().intValue() == this.index;
        }

        public String toString() {
            return String.format(":eq(%d)", Integer.valueOf(this.index));
        }
    }

    /* loaded from: classes.dex */
    public final class IsLastChild extends Evaluator {
        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            Element parent = element2.parent();
            return (parent == null || (parent instanceof Document) || element2.elementSiblingIndex().intValue() != parent.children().size() + (-1)) ? false : true;
        }

        public String toString() {
            return ":last-child";
        }
    }

    /* loaded from: classes.dex */
    public final class IsFirstOfType extends IsNthOfType {
        public IsFirstOfType() {
            super(0, 1);
        }

        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        public String toString() {
            return ":first-of-type";
        }
    }

    /* loaded from: classes.dex */
    public final class IsLastOfType extends IsNthLastOfType {
        public IsLastOfType() {
            super(0, 1);
        }

        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        public String toString() {
            return ":last-of-type";
        }
    }

    /* loaded from: classes.dex */
    public abstract class CssNthEvaluator extends Evaluator {
        protected final int a;
        protected final int b;

        protected abstract int calculatePosition(Element element, Element element2);

        protected abstract String getPseudoClass();

        public CssNthEvaluator(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public CssNthEvaluator(int i) {
            this(0, i);
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            Element parent = element2.parent();
            if (parent == null || (parent instanceof Document)) {
                return false;
            }
            int calculatePosition = calculatePosition(element, element2);
            return this.a == 0 ? calculatePosition == this.b : (calculatePosition - this.b) * this.a >= 0 && (calculatePosition - this.b) % this.a == 0;
        }

        public String toString() {
            if (this.a == 0) {
                return String.format(":%s(%d)", getPseudoClass(), Integer.valueOf(this.b));
            }
            if (this.b == 0) {
                return String.format(":%s(%dn)", getPseudoClass(), Integer.valueOf(this.a));
            }
            return String.format(":%s(%dn%+d)", getPseudoClass(), Integer.valueOf(this.a), Integer.valueOf(this.b));
        }
    }

    /* loaded from: classes.dex */
    public final class IsNthChild extends CssNthEvaluator {
        public IsNthChild(int i, int i2) {
            super(i, i2);
        }

        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        protected int calculatePosition(Element element, Element element2) {
            return element2.elementSiblingIndex().intValue() + 1;
        }

        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        protected String getPseudoClass() {
            return "nth-child";
        }
    }

    /* loaded from: classes.dex */
    public final class IsNthLastChild extends CssNthEvaluator {
        public IsNthLastChild(int i, int i2) {
            super(i, i2);
        }

        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        protected int calculatePosition(Element element, Element element2) {
            return element2.parent().children().size() - element2.elementSiblingIndex().intValue();
        }

        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        protected String getPseudoClass() {
            return "nth-last-child";
        }
    }

    /* loaded from: classes.dex */
    public class IsNthOfType extends CssNthEvaluator {
        public IsNthOfType(int i, int i2) {
            super(i, i2);
        }

        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        protected int calculatePosition(Element element, Element element2) {
            Elements children = element2.parent().children();
            int i = 0;
            for (int i2 = 0; i2 < children.size(); i2++) {
                if (children.get(i2).tag() == element2.tag()) {
                    i++;
                }
                if (children.get(i2) == element2) {
                    break;
                }
            }
            return i;
        }

        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        protected String getPseudoClass() {
            return "nth-of-type";
        }
    }

    /* loaded from: classes.dex */
    public class IsNthLastOfType extends CssNthEvaluator {
        public IsNthLastOfType(int i, int i2) {
            super(i, i2);
        }

        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        protected int calculatePosition(Element element, Element element2) {
            int i = 0;
            Elements children = element2.parent().children();
            for (int intValue = element2.elementSiblingIndex().intValue(); intValue < children.size(); intValue++) {
                if (children.get(intValue).tag() == element2.tag()) {
                    i++;
                }
            }
            return i;
        }

        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        protected String getPseudoClass() {
            return "nth-last-of-type";
        }
    }

    /* loaded from: classes.dex */
    public final class IsFirstChild extends Evaluator {
        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            Element parent = element2.parent();
            return (parent == null || (parent instanceof Document) || element2.elementSiblingIndex().intValue() != 0) ? false : true;
        }

        public String toString() {
            return ":first-child";
        }
    }

    /* loaded from: classes.dex */
    public final class IsRoot extends Evaluator {
        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            if (element instanceof Document) {
                element = element.child(0);
            }
            return element2 == element;
        }

        public String toString() {
            return ":root";
        }
    }

    /* loaded from: classes.dex */
    public final class IsOnlyChild extends Evaluator {
        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            Element parent = element2.parent();
            return (parent == null || (parent instanceof Document) || element2.siblingElements().size() != 0) ? false : true;
        }

        public String toString() {
            return ":only-child";
        }
    }

    /* loaded from: classes.dex */
    public final class IsOnlyOfType extends Evaluator {
        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            Element parent = element2.parent();
            if (parent == null || (parent instanceof Document)) {
                return false;
            }
            Elements children = parent.children();
            int i = 0;
            for (int i2 = 0; i2 < children.size(); i2++) {
                if (children.get(i2).tag().equals(element2.tag())) {
                    i++;
                }
            }
            return i == 1;
        }

        public String toString() {
            return ":only-of-type";
        }
    }

    /* loaded from: classes.dex */
    public final class IsEmpty extends Evaluator {
        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            List<Node> childNodes = element2.childNodes();
            for (int i = 0; i < childNodes.size(); i++) {
                Node node = childNodes.get(i);
                if (!(node instanceof Comment) && !(node instanceof XmlDeclaration) && !(node instanceof DocumentType)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return ":empty";
        }
    }

    /* loaded from: classes.dex */
    public abstract class IndexEvaluator extends Evaluator {
        int index;

        public IndexEvaluator(int i) {
            this.index = i;
        }
    }

    /* loaded from: classes.dex */
    public final class ContainsText extends Evaluator {
        private String searchText;

        public ContainsText(String str) {
            this.searchText = str.toLowerCase();
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.text().toLowerCase().contains(this.searchText);
        }

        public String toString() {
            return String.format(":contains(%s", this.searchText);
        }
    }

    /* loaded from: classes.dex */
    public final class ContainsOwnText extends Evaluator {
        private String searchText;

        public ContainsOwnText(String str) {
            this.searchText = str.toLowerCase();
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.ownText().toLowerCase().contains(this.searchText);
        }

        public String toString() {
            return String.format(":containsOwn(%s", this.searchText);
        }
    }

    /* loaded from: classes.dex */
    public final class Matches extends Evaluator {
        private Pattern pattern;

        public Matches(Pattern pattern) {
            this.pattern = pattern;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return this.pattern.matcher(element2.text()).find();
        }

        public String toString() {
            return String.format(":matches(%s", this.pattern);
        }
    }

    /* loaded from: classes.dex */
    public final class MatchesOwn extends Evaluator {
        private Pattern pattern;

        public MatchesOwn(Pattern pattern) {
            this.pattern = pattern;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return this.pattern.matcher(element2.ownText()).find();
        }

        public String toString() {
            return String.format(":matchesOwn(%s", this.pattern);
        }
    }
}
