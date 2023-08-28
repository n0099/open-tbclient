package com.yy.render.trans;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.mobstat.Config;
import com.baidu.nps.main.manager.Bundle;
import com.baidu.tieba.dzb;
import com.baidu.tieba.jzb;
import com.baidu.tieba.mzb;
import com.yy.render.IRemoteRender;
import com.yy.render.ITransDataListener;
import com.yy.render.RenderEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u000247\b&\u0018\u0000B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b?\u0010\"J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0011H&¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH&¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH&¢\u0006\u0004\b\u0018\u0010\u0019J5\u0010\u001e\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\tH&¢\u0006\u0004\b!\u0010\"J\u0015\u0010#\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0011¢\u0006\u0004\b#\u0010$J\u0015\u0010%\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0011¢\u0006\u0004\b%\u0010&J\u0015\u0010'\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0011¢\u0006\u0004\b'\u0010(J\u0015\u0010)\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b)\u0010\"J\u0015\u0010*\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b*\u0010+J\u0015\u0010,\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\u0006¢\u0006\u0004\b.\u0010/R\"\u0010\n\u001a\u00020\t8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\n\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u0010\"R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00100R\u0018\u0010<\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u001c\u0010\u001c\u001a\u00020\t8\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u001c\u00100\u001a\u0004\b>\u00102¨\u0006@"}, d2 = {"Lcom/yy/render/trans/SimpleClientMessageSender;", "", "close", "()V", "Ljava/lang/Class;", Bundle.EXTRA_KEY_CLAZZ, "", "init", "(Ljava/lang/Class;)Z", "", "channelId", "Landroid/graphics/Bitmap;", "data", "onBitmapFromServer", "(Ljava/lang/String;Landroid/graphics/Bitmap;)V", "onBitmapFromServerForStr", "(Ljava/lang/String;Landroid/graphics/Bitmap;)Ljava/lang/String;", "Landroid/os/Bundle;", "onBundleFromServer", "(Ljava/lang/String;Landroid/os/Bundle;)V", "onBundleFromServerForStr", "(Ljava/lang/String;Landroid/os/Bundle;)Ljava/lang/String;", "onDataFromServer", "(Ljava/lang/String;Ljava/lang/String;)V", "onDataFromServerForStr", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "level", "tag", "message", "onLog", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", Config.EXCEPTION_PART, "onServiceCrash", "(Ljava/lang/String;)V", "sendBundleToServer", "(Landroid/os/Bundle;)V", "sendBundleToServerForBoolean", "(Landroid/os/Bundle;)Z", "sendBundleToServerForStr", "(Landroid/os/Bundle;)Ljava/lang/String;", "sendDataToServer", "sendDataToServerForBoolean", "(Ljava/lang/String;)Z", "sendDataToServerForStr", "(Ljava/lang/String;)Ljava/lang/String;", "unRegister", "()Z", "Ljava/lang/String;", "getChannelId", "()Ljava/lang/String;", "setChannelId", "com/yy/render/trans/SimpleClientMessageSender$iCrash$1", "iCrash", "Lcom/yy/render/trans/SimpleClientMessageSender$iCrash$1;", "com/yy/render/trans/SimpleClientMessageSender$iTransDataListener$1", "iTransDataListener", "Lcom/yy/render/trans/SimpleClientMessageSender$iTransDataListener$1;", "initFailReason", "Lcom/yy/render/IRemoteRender;", "sender", "Lcom/yy/render/IRemoteRender;", "getTag", "<init>", "render_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public abstract class SimpleClientMessageSender {
    public IRemoteRender b;
    public String e;
    public final String a = "MessageChannel";
    public final SimpleClientMessageSender$iTransDataListener$1 c = new ITransDataListener.Stub() { // from class: com.yy.render.trans.SimpleClientMessageSender$iTransDataListener$1
        @Override // com.yy.render.ITransDataListener
        public void log(String str, int i, String str2, String str3) {
            SimpleClientMessageSender.this.j(str, i, str2, str3);
        }

        @Override // com.yy.render.ITransDataListener
        public void transBitmap(String str, Bitmap bitmap) {
            boolean z;
            mzb.a aVar = mzb.b;
            String b = SimpleClientMessageSender.this.b();
            aVar.g(b, "[client](transBitmap) channelId:" + str);
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z && bitmap != null) {
                SimpleClientMessageSender.this.d(str, bitmap);
            }
        }

        @Override // com.yy.render.ITransDataListener
        public String transBitmapForStr(String str, Bitmap bitmap) {
            boolean z;
            mzb.a aVar = mzb.b;
            String b = SimpleClientMessageSender.this.b();
            aVar.g(b, "[client](transBitmapForStr) channelId:" + str);
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z && bitmap != null) {
                return SimpleClientMessageSender.this.e(str, bitmap);
            }
            return "";
        }

        @Override // com.yy.render.ITransDataListener
        public void transBundle(String str, android.os.Bundle bundle) {
            boolean z;
            mzb.a aVar = mzb.b;
            String b = SimpleClientMessageSender.this.b();
            aVar.g(b, "[client](transBundle) channelId:" + str);
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z && bundle != null) {
                SimpleClientMessageSender.this.f(str, bundle);
            }
        }

        @Override // com.yy.render.ITransDataListener
        public String transBundleForStr(String str, android.os.Bundle bundle) {
            boolean z;
            mzb.a aVar = mzb.b;
            String b = SimpleClientMessageSender.this.b();
            aVar.g(b, "[client](transBundleForStr) channelId:" + str);
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z && bundle != null) {
                return SimpleClientMessageSender.this.g(str, bundle);
            }
            return "";
        }

        @Override // com.yy.render.ITransDataListener
        public void transData(String str, String str2) {
            boolean z;
            mzb.a aVar = mzb.b;
            String b = SimpleClientMessageSender.this.b();
            aVar.g(b, "[client](transData) channelId:" + str + ", data:" + str2);
            boolean z2 = false;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                if (!((str2 == null || str2.length() == 0) ? true : true)) {
                    SimpleClientMessageSender.this.h(str, str2);
                }
            }
        }

        @Override // com.yy.render.ITransDataListener
        public String transDataForStr(String str, String str2) {
            boolean z;
            mzb.a aVar = mzb.b;
            String b = SimpleClientMessageSender.this.b();
            aVar.g(b, "[client](transDataForStr) channelId:" + str + ", data:" + str2);
            boolean z2 = false;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                if (!((str2 == null || str2.length() == 0) ? true : true)) {
                    return SimpleClientMessageSender.this.i(str, str2);
                }
                return "";
            }
            return "";
        }
    };
    public final a d = new a();

    public abstract void d(String str, Bitmap bitmap);

    public abstract String e(String str, Bitmap bitmap);

    public abstract void f(String str, android.os.Bundle bundle);

    public abstract String g(String str, android.os.Bundle bundle);

    public abstract void h(String str, String str2);

    public abstract String i(String str, String str2);

    public abstract void j(String str, int i, String str2, String str3);

    public abstract void k(String str);

    /* loaded from: classes10.dex */
    public static final class a implements dzb {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.baidu.tieba.dzb
        public void a(String str) {
            mzb.a aVar = mzb.b;
            String b = SimpleClientMessageSender.this.b();
            aVar.d(b, "[client] service crash ex: " + str);
            SimpleClientMessageSender.this.a();
            SimpleClientMessageSender.this.k(str);
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.yy.render.trans.SimpleClientMessageSender$iTransDataListener$1] */
    public SimpleClientMessageSender(String str) {
        this.e = str;
    }

    public final void a() {
        mzb.b.g(this.a, "[client](close)");
        RenderEngine.r.a().C(this.d);
        m();
        this.b = null;
    }

    public final String b() {
        return this.a;
    }

    public final boolean c(Class<?> cls) {
        boolean z = false;
        if (!jzb.class.isAssignableFrom(cls)) {
            mzb.b.g(this.a, "[client](init)register error clazz type");
            return false;
        }
        boolean w = RenderEngine.r.a().w();
        boolean x = RenderEngine.r.a().x();
        IRemoteRender t = RenderEngine.r.a().t();
        mzb.b.g(this.a, "[client](init) isSucc: " + w + ", isSdkOk: " + x);
        if (x && w) {
            if (t == null) {
                mzb.b.g(this.a, "[client](init) binder is null");
                return false;
            }
            StringBuilder sb = new StringBuilder();
            Package r2 = cls.getPackage();
            Intrinsics.checkExpressionValueIsNotNull(r2, "clazz.`package`");
            sb.append(r2.getName());
            sb.append(IStringUtil.EXTENSION_SEPARATOR);
            sb.append(cls.getSimpleName());
            String sb2 = sb.toString();
            IRemoteRender t2 = RenderEngine.r.a().t();
            this.b = t2;
            if (t2 != null) {
                try {
                    z = t2.registerDataListener(this.e, sb2, this.c);
                } catch (Exception e) {
                    String str = "register ex: " + e.getMessage();
                    mzb.b.d(this.a, "[client](init) register ex: " + e.getMessage());
                    e.printStackTrace();
                }
            }
            if (z) {
                mzb.b.d(this.a, "[client](init) add crash listener");
                RenderEngine.r.a().q(this.d);
            }
        }
        return z;
    }

    public final void l(String str) {
        if (TextUtils.isEmpty(this.e)) {
            mzb.b.g(this.a, "[client](sendDataToServer) channelId is empty or null");
            return;
        }
        IRemoteRender iRemoteRender = this.b;
        if (iRemoteRender == null) {
            mzb.b.g(this.a, "[client](sendDataToServer) binder is null");
        } else if (iRemoteRender != null) {
            try {
                iRemoteRender.sendData(this.e, str);
            } catch (Exception e) {
                mzb.a aVar = mzb.b;
                String str2 = this.a;
                aVar.d(str2, "[client](sendDataToServer) ex: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public final boolean m() {
        Boolean bool;
        try {
            IRemoteRender iRemoteRender = this.b;
            if (iRemoteRender != null) {
                bool = Boolean.valueOf(iRemoteRender.unRegisterDataListener(this.e, this.c));
            } else {
                bool = null;
            }
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        } catch (Exception e) {
            mzb.a aVar = mzb.b;
            String str = this.a;
            aVar.d(str, "[client](unRegister) ex: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
