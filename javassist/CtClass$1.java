package javassist;
/* loaded from: classes.dex */
class CtClass$1 extends ClassMap {
    final /* synthetic */ h this$0;

    CtClass$1(h hVar) {
        this.this$0 = hVar;
    }

    @Override // javassist.ClassMap
    public void put(String str, String str2) {
        put0(str, str2);
    }

    @Override // javassist.ClassMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        String javaName = toJavaName((String) obj);
        put0(javaName, javaName);
        return null;
    }

    @Override // javassist.ClassMap
    public void fix(String str) {
    }
}
