package javassist.util.proxy;
/* loaded from: classes.dex */
final class g implements l {

    /* renamed from: a  reason: collision with root package name */
    private final String f2824a = "_$$_jvst" + Integer.toHexString(hashCode() & 4095) + "_";
    private int b = 0;

    @Override // javassist.util.proxy.l
    public String a(String str) {
        StringBuilder append = new StringBuilder().append(str).append(this.f2824a);
        int i = this.b;
        this.b = i + 1;
        return append.append(Integer.toHexString(i)).toString();
    }
}
