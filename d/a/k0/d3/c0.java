package d.a.k0.d3;

import tbclient.SmartApp;
/* loaded from: classes5.dex */
public class c0 {

    /* renamed from: a  reason: collision with root package name */
    public String f53732a;

    /* renamed from: b  reason: collision with root package name */
    public String f53733b;

    /* renamed from: c  reason: collision with root package name */
    public String f53734c;

    /* renamed from: d  reason: collision with root package name */
    public Integer f53735d;

    public void a(SmartApp smartApp) {
        if (smartApp == null) {
            return;
        }
        String str = smartApp.avatar;
        this.f53732a = smartApp.name;
        this.f53733b = smartApp.id;
        this.f53734c = smartApp.link;
        this.f53735d = smartApp.is_game;
    }
}
