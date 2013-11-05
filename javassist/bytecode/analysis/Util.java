package javassist.bytecode.analysis;

import javassist.bytecode.CodeIterator;
import javassist.bytecode.as;
/* loaded from: classes.dex */
public class Util implements as {
    public static int a(int i, CodeIterator codeIterator) {
        int c = codeIterator.c(i);
        return ((c == 201 || c == 200) ? codeIterator.f(i + 1) : codeIterator.e(i + 1)) + i;
    }

    public static boolean a(int i) {
        return (i >= 153 && i <= 168) || i == 198 || i == 199 || i == 201 || i == 200;
    }

    public static boolean b(int i) {
        return i == 167 || i == 200;
    }

    public static boolean c(int i) {
        return i == 168 || i == 201;
    }

    public static boolean d(int i) {
        return i >= 172 && i <= 177;
    }
}
