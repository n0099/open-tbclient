package d.b.j0.d3;

import tbclient.SmartApp;
/* loaded from: classes5.dex */
public class c0 {

    /* renamed from: a  reason: collision with root package name */
    public String f55188a;

    /* renamed from: b  reason: collision with root package name */
    public String f55189b;

    /* renamed from: c  reason: collision with root package name */
    public String f55190c;

    /* renamed from: d  reason: collision with root package name */
    public Integer f55191d;

    public void a(SmartApp smartApp) {
        if (smartApp == null) {
            return;
        }
        String str = smartApp.avatar;
        this.f55188a = smartApp.name;
        this.f55189b = smartApp.id;
        this.f55190c = smartApp.link;
        this.f55191d = smartApp.is_game;
    }
}
