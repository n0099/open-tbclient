package com.kwad.sdk.d.kwai;

import com.kwad.sdk.mvp.Presenter;
import java.util.List;
/* loaded from: classes7.dex */
public class b extends Presenter {
    public void g() {
        List<Presenter> n = n();
        if (n == null) {
            return;
        }
        for (Presenter presenter : n) {
            if (presenter instanceof b) {
                ((b) presenter).g();
            }
        }
    }

    public void h() {
        List<Presenter> n = n();
        if (n == null) {
            return;
        }
        for (Presenter presenter : n) {
            if (presenter instanceof b) {
                ((b) presenter).h();
            }
        }
    }
}
