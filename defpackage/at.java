package defpackage;

import android.content.Context;
import com.baidu.cloudsdk.common.util.Validator;
import com.baidu.cloudsdk.social.core.MediaType;
/* renamed from: at  reason: default package */
/* loaded from: classes.dex */
public class at {
    private MediaType a;
    private boolean b = false;
    private boolean c = false;
    private String d;

    private at(Context context, MediaType mediaType) {
        this.a = mediaType;
    }

    public static at a(Context context, MediaType mediaType) {
        Validator.notNull(context, "context");
        Validator.notNull(mediaType, "mediaType");
        switch (mediaType) {
            case SINAWEIBO:
                return new at(context, mediaType);
            case QQWEIBO:
                return new at(context, mediaType);
            case RENREN:
                return new at(context, mediaType);
            case KAIXIN:
                return new at(context, mediaType);
            case QZONE:
                return new at(context, mediaType);
            default:
                return null;
        }
    }

    public MediaType a() {
        return this.a;
    }

    public void a(String str) {
        this.d = str;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public String b() {
        return this.d;
    }

    public void b(boolean z) {
        this.b = z;
    }

    public boolean c() {
        return this.c;
    }

    public boolean d() {
        return this.b;
    }
}
