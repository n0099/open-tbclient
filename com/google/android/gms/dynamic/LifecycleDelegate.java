package com.google.android.gms.dynamic;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public interface LifecycleDelegate {
    View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    void a();

    void a(Activity activity, Bundle bundle, Bundle bundle2);

    void a(Bundle bundle);

    void b();

    void b(Bundle bundle);

    void c();

    void d();

    void e();
}
