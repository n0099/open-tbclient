package d.a.w0.s;

import java.util.ArrayList;
/* loaded from: classes8.dex */
public interface a {

    /* renamed from: d.a.w0.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC1949a {
        void onCompletion();

        boolean onError(int i2, int i3, Object obj);

        boolean onInfo(int i2, int i3, Object obj);
    }

    void release();

    void setListener(InterfaceC1949a interfaceC1949a);

    void setSource(ArrayList<String> arrayList);

    void start();
}
