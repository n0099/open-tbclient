package d.b.i0.b1.a;

import java.util.Random;
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Random f53287a = new Random();

    public static int a(int i, int i2) {
        return i >= i2 ? i : (int) ((f53287a.nextFloat() * (i2 - i)) + i);
    }
}
