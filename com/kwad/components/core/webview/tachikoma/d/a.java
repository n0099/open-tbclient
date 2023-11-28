package com.kwad.components.core.webview.tachikoma.d;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.google.android.exoplayer2.extractor.ts.H262Reader;
import com.kwad.sdk.utils.bn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a {
    public List<Integer> aaD;
    public final List<Integer> aaE;

    /* renamed from: com.kwad.components.core.webview.tachikoma.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0671a {
        public static final a aaI = new a((byte) 0);
    }

    public a() {
        this.aaD = new ArrayList();
        this.aaE = Arrays.asList(123, Integer.valueOf((int) H262Reader.START_GROUP), Integer.valueOf((int) Constants.METHOD_IM_SEND_MCAST_MSG), 190, Integer.valueOf((int) Constants.METHOD_IM_DEL_BUSINESS_SESSION_MSG), 200);
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO(String str) {
        int i;
        try {
            i = new JSONObject(str).optInt("elementType");
        } catch (Exception unused) {
            i = Integer.MAX_VALUE;
        }
        if (!this.aaE.contains(Integer.valueOf(i))) {
            return;
        }
        this.aaD.add(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ(int i) {
        if (!this.aaE.contains(Integer.valueOf(i))) {
            return;
        }
        this.aaD.add(Integer.valueOf(i));
    }

    public final void aP(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.d.a.2
            @Override // java.lang.Runnable
            public final void run() {
                a.this.aO(str);
            }
        });
    }

    public final void aR(final int i) {
        bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.d.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.aQ(i);
            }
        });
    }

    public static a sO() {
        return C0671a.aaI;
    }

    public final List<Integer> sP() {
        return this.aaD;
    }

    public final void sQ() {
        this.aaD.clear();
    }
}
