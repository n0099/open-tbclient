package d.b.i0.c3;

import tbclient.SmartApp;
/* loaded from: classes5.dex */
public class c0 {

    /* renamed from: a  reason: collision with root package name */
    public String f53325a;

    /* renamed from: b  reason: collision with root package name */
    public String f53326b;

    /* renamed from: c  reason: collision with root package name */
    public String f53327c;

    /* renamed from: d  reason: collision with root package name */
    public Integer f53328d;

    public void a(SmartApp smartApp) {
        if (smartApp == null) {
            return;
        }
        String str = smartApp.avatar;
        this.f53325a = smartApp.name;
        this.f53326b = smartApp.id;
        this.f53327c = smartApp.link;
        this.f53328d = smartApp.is_game;
    }
}
