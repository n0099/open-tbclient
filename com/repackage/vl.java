package com.repackage;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
/* loaded from: classes7.dex */
public interface vl extends ul {
    FragmentManager proxyGetSupportFragmentManager();

    void proxyOnAttachFragment(Fragment fragment);

    void proxyStartActivityFromFragment(Fragment fragment, Intent intent, int i);
}
