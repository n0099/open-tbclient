package com.sina.weibo.sdk.component;
/* loaded from: classes3.dex */
enum BrowserLauncher {
    AUTH,
    SHARE,
    WIDGET,
    COMMON,
    GAME;

    /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static BrowserLauncher[] valuesCustom() {
        BrowserLauncher[] valuesCustom = values();
        int length = valuesCustom.length;
        BrowserLauncher[] browserLauncherArr = new BrowserLauncher[length];
        System.arraycopy(valuesCustom, 0, browserLauncherArr, 0, length);
        return browserLauncherArr;
    }
}
