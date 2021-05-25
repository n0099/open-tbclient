package d.a.n0.e3;

import tbclient.SmartApp;
/* loaded from: classes5.dex */
public class c0 {

    /* renamed from: a  reason: collision with root package name */
    public String f53945a;

    /* renamed from: b  reason: collision with root package name */
    public String f53946b;

    /* renamed from: c  reason: collision with root package name */
    public String f53947c;

    /* renamed from: d  reason: collision with root package name */
    public Integer f53948d;

    public void a(SmartApp smartApp) {
        if (smartApp == null) {
            return;
        }
        String str = smartApp.avatar;
        this.f53945a = smartApp.name;
        this.f53946b = smartApp.id;
        this.f53947c = smartApp.link;
        this.f53948d = smartApp.is_game;
    }
}
