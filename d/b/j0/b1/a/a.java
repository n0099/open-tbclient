package d.b.j0.b1.a;

import java.util.Random;
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Random f53708a = new Random();

    public static int a(int i, int i2) {
        return i >= i2 ? i : (int) ((f53708a.nextFloat() * (i2 - i)) + i);
    }
}
