package com.kascend.chushou.widget.gif;

import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.Px;
import android.support.v4.view.ViewCompat;
import android.text.Spannable;
import android.text.style.ImageSpan;
import android.widget.TextView;
import com.kascend.chushou.player.ui.pk.f;
import java.io.File;
import java.lang.ref.WeakReference;
import pl.droidsonroids.gif.GifDrawable;
import tv.chushou.basis.http.HttpConsts;
import tv.chushou.basis.http.listener.DownloadListener;
import tv.chushou.zues.widget.a.e;
/* loaded from: classes5.dex */
public class b extends e {
    private static final tv.chushou.zues.toolkit.b.a ngp = tv.chushou.zues.toolkit.b.a.nYC;

    private b(GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    /* loaded from: classes5.dex */
    public static class a {
        private String a;
        @DrawableRes
        private int b;
        @Px
        private int c;
        @Px
        private int d;
        private WeakReference<TextView> e;
        private boolean f = false;
        private Drawable.Callback nkA;

        public a Rd(String str) {
            f.a(str);
            this.a = str;
            return this;
        }

        public a Nj(@DrawableRes int i) {
            this.b = i;
            return this;
        }

        public a Nk(@Px int i) {
            this.c = i;
            return this;
        }

        public a Nl(@Px int i) {
            this.d = i;
            return this;
        }

        public a f(TextView textView) {
            this.e = new WeakReference<>(textView);
            return this;
        }

        public a wB(boolean z) {
            this.f = z;
            return this;
        }

        public a a(Drawable.Callback callback) {
            this.nkA = callback;
            return this;
        }

        public ImageSpan dFd() {
            Drawable drawable;
            f.a(this.a);
            f.a(this.d != 0, "should set height");
            String SS = b.ngp.SS(this.a);
            File c = com.kascend.chushou.d.c.mQR.c();
            final File file = new File(c, SS);
            if (!file.exists() || file.isDirectory()) {
                com.kascend.chushou.c.c.dCo().a(this.a, new File(c, SS + HttpConsts.FILE_BACKUP_SUFFIX), new DownloadListener() { // from class: com.kascend.chushou.widget.gif.b.a.1
                    @Override // tv.chushou.basis.d.a.c.a
                    public void onStart() {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // tv.chushou.basis.d.a.c.a
                    /* renamed from: a */
                    public void onSuccess(File file2) {
                        CharSequence text;
                        GifDrawable gifDrawable;
                        file2.renameTo(file);
                        TextView textView = (TextView) a.this.e.get();
                        if (textView != null && ViewCompat.isAttachedToWindow(textView) && (text = textView.getText()) != null && text.length() != 0 && (text instanceof Spannable)) {
                            Spannable spannable = (Spannable) text;
                            c[] cVarArr = (c[]) spannable.getSpans(0, spannable.length(), c.class);
                            if (cVarArr != null && cVarArr.length != 0) {
                                boolean z = false;
                                for (c cVar : cVarArr) {
                                    if (a.this.a.equals(cVar.a())) {
                                        try {
                                            gifDrawable = new GifDrawable(file);
                                        } catch (Throwable th) {
                                            gifDrawable = null;
                                        }
                                        if (gifDrawable != null) {
                                            int i = a.this.c;
                                            if (a.this.f) {
                                                i = (gifDrawable.getIntrinsicWidth() * a.this.d) / gifDrawable.getIntrinsicHeight();
                                            }
                                            gifDrawable.setBounds(0, 0, i, a.this.d);
                                            gifDrawable.setCallback(a.this.nkA);
                                            int spanStart = spannable.getSpanStart(cVar);
                                            int spanEnd = spannable.getSpanEnd(cVar);
                                            spannable.removeSpan(cVar);
                                            spannable.setSpan(new b(gifDrawable), spanStart, spanEnd, 33);
                                            z = true;
                                        } else {
                                            file.delete();
                                            return;
                                        }
                                    }
                                }
                                if (z) {
                                    textView.setText(spannable);
                                }
                            }
                        }
                    }

                    @Override // tv.chushou.basis.d.a.c.a
                    public void onFailure(int i, @Nullable String str, @Nullable Throwable th) {
                    }

                    @Override // tv.chushou.basis.http.listener.DownloadListener
                    public void onProgress(int i) {
                    }
                });
                Drawable drawable2 = tv.chushou.widget.a.c.getDrawable(this.b);
                int i = this.c;
                if (this.f) {
                    i = (drawable2.getIntrinsicWidth() * this.d) / drawable2.getIntrinsicHeight();
                }
                drawable2.setBounds(0, 0, i, this.d);
                return new c(drawable2, this.a);
            }
            try {
                drawable = new GifDrawable(file);
            } catch (Throwable th) {
                file.delete();
                drawable = tv.chushou.widget.a.c.getDrawable(this.b);
            }
            int i2 = this.c;
            if (this.f) {
                i2 = (drawable.getIntrinsicWidth() * this.d) / drawable.getIntrinsicHeight();
            }
            drawable.setBounds(0, 0, i2, this.d);
            if (drawable instanceof GifDrawable) {
                drawable.setCallback(this.nkA);
                return new b((GifDrawable) drawable);
            }
            return new e(drawable);
        }
    }
}
