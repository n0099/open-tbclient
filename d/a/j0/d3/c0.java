package d.a.j0.d3;

import tbclient.SmartApp;
/* loaded from: classes5.dex */
public class c0 {

    /* renamed from: a  reason: collision with root package name */
    public String f53025a;

    /* renamed from: b  reason: collision with root package name */
    public String f53026b;

    /* renamed from: c  reason: collision with root package name */
    public String f53027c;

    /* renamed from: d  reason: collision with root package name */
    public Integer f53028d;

    public void a(SmartApp smartApp) {
        if (smartApp == null) {
            return;
        }
        String str = smartApp.avatar;
        this.f53025a = smartApp.name;
        this.f53026b = smartApp.id;
        this.f53027c = smartApp.link;
        this.f53028d = smartApp.is_game;
    }
}
