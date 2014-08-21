package org.jsoup.examples;

import java.util.Iterator;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/* loaded from: classes.dex */
public class ListLinks {
    public static void main(String[] strArr) {
        Validate.isTrue(strArr.length == 1, "usage: supply url to fetch");
        String str = strArr[0];
        print("Fetching %s...", str);
        Document document = Jsoup.connect(str).get();
        Elements select = document.select("a[href]");
        Elements select2 = document.select("[src]");
        Elements select3 = document.select("link[href]");
        print("\nMedia: (%d)", Integer.valueOf(select2.size()));
        Iterator<Element> it = select2.iterator();
        while (it.hasNext()) {
            Element next = it.next();
            if (next.tagName().equals("img")) {
                print(" * %s: <%s> %sx%s (%s)", next.tagName(), next.attr("abs:src"), next.attr("width"), next.attr("height"), trim(next.attr("alt"), 20));
            } else {
                print(" * %s: <%s>", next.tagName(), next.attr("abs:src"));
            }
        }
        print("\nImports: (%d)", Integer.valueOf(select3.size()));
        Iterator<Element> it2 = select3.iterator();
        while (it2.hasNext()) {
            Element next2 = it2.next();
            print(" * %s <%s> (%s)", next2.tagName(), next2.attr("abs:href"), next2.attr("rel"));
        }
        print("\nLinks: (%d)", Integer.valueOf(select.size()));
        Iterator<Element> it3 = select.iterator();
        while (it3.hasNext()) {
            Element next3 = it3.next();
            print(" * a: <%s>  (%s)", next3.attr("abs:href"), trim(next3.text(), 35));
        }
    }

    private static void print(String str, Object... objArr) {
        System.out.println(String.format(str, objArr));
    }

    private static String trim(String str, int i) {
        if (str.length() > i) {
            return str.substring(0, i - 1) + ".";
        }
        return str;
    }
}
