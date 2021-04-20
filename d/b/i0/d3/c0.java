package d.b.i0.d3;

import tbclient.SmartApp;
/* loaded from: classes3.dex */
public class c0 {

    /* renamed from: a  reason: collision with root package name */
    public String f54767a;

    /* renamed from: b  reason: collision with root package name */
    public String f54768b;

    /* renamed from: c  reason: collision with root package name */
    public String f54769c;

    /* renamed from: d  reason: collision with root package name */
    public Integer f54770d;

    public void a(SmartApp smartApp) {
        if (smartApp == null) {
            return;
        }
        String str = smartApp.avatar;
        this.f54767a = smartApp.name;
        this.f54768b = smartApp.id;
        this.f54769c = smartApp.link;
        this.f54770d = smartApp.is_game;
    }
}
