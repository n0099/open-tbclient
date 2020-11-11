package com.qiniu.android.utils;

import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public final class StringMap {
    private Map<String, Object> map;

    /* loaded from: classes6.dex */
    public interface Consumer {
        void N(String str, Object obj);
    }

    public StringMap() {
        this(new HashMap());
    }

    public StringMap(Map<String, Object> map) {
        this.map = map;
    }

    public StringMap O(String str, Object obj) {
        this.map.put(str, obj);
        return this;
    }

    public StringMap K(Map<String, String> map) {
        this.map.putAll(map);
        return this;
    }

    public void a(Consumer consumer) {
        for (Map.Entry<String, Object> entry : this.map.entrySet()) {
            consumer.N(entry.getKey(), entry.getValue());
        }
    }

    public Object get(String str) {
        return this.map.get(str);
    }

    /* renamed from: com.qiniu.android.utils.StringMap$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass1 implements Consumer {
        private boolean pHw;
        final /* synthetic */ StringBuilder pHx;

        @Override // com.qiniu.android.utils.StringMap.Consumer
        public void N(String str, Object obj) {
            if (this.pHw) {
                this.pHx.append(ETAG.ITEM_SEPARATOR);
            }
            try {
                this.pHx.append(URLEncoder.encode(str, "UTF-8")).append('=').append(URLEncoder.encode(obj.toString(), "UTF-8"));
                this.pHw = true;
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
    }
}
