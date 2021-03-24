package d.b.i0.c3;

import tbclient.SmartApp;
/* loaded from: classes5.dex */
public class c0 {

    /* renamed from: a  reason: collision with root package name */
    public String f53324a;

    /* renamed from: b  reason: collision with root package name */
    public String f53325b;

    /* renamed from: c  reason: collision with root package name */
    public String f53326c;

    /* renamed from: d  reason: collision with root package name */
    public Integer f53327d;

    public void a(SmartApp smartApp) {
        if (smartApp == null) {
            return;
        }
        String str = smartApp.avatar;
        this.f53324a = smartApp.name;
        this.f53325b = smartApp.id;
        this.f53326c = smartApp.link;
        this.f53327d = smartApp.is_game;
    }
}
