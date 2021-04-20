package d.b.c.h.f;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
/* loaded from: classes.dex */
public interface b extends a {
    FragmentManager proxyGetSupportFragmentManager();

    void proxyOnAttachFragment(Fragment fragment);

    void proxyStartActivityFromFragment(Fragment fragment, Intent intent, int i);
}
