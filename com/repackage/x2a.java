package com.repackage;

import android.view.View;
import android.view.Window;
import tv.athena.revenue.payui.view.WindowParams;
/* loaded from: classes7.dex */
public interface x2a {
    void attachWindow(Window window);

    View getContentView();

    void refreshView();

    void refreshWindow(WindowParams windowParams);
}
