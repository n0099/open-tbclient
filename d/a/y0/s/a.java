package d.a.y0.s;

import java.util.ArrayList;
/* loaded from: classes9.dex */
public interface a {

    /* renamed from: d.a.y0.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1985a {
        void onCompletion();

        boolean onError(int i2, int i3, Object obj);

        boolean onInfo(int i2, int i3, Object obj);
    }

    void release();

    void setListener(InterfaceC1985a interfaceC1985a);

    void setSource(ArrayList<String> arrayList);

    void start();
}
