package d.b.i0.a1.a;

import java.util.Random;
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Random f51866a = new Random();

    public static int a(int i, int i2) {
        return i >= i2 ? i : (int) ((f51866a.nextFloat() * (i2 - i)) + i);
    }
}
