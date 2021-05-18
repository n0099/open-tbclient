package d.a.k0.b1.a;

import java.util.Random;
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Random f52153a = new Random();

    public static int a(int i2, int i3) {
        return i2 >= i3 ? i2 : (int) ((f52153a.nextFloat() * (i3 - i2)) + i2);
    }
}
