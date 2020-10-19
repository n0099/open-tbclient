package com.kascend.chushou.player.ui.pk;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.widget.ImageView;
import java.lang.ref.SoftReference;
/* loaded from: classes6.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    protected int[] f4213a;
    protected int b;
    protected long c;
    protected int d;
    protected int e;
    protected long f;
    private Bitmap h;
    private boolean j;
    private int k;
    private boolean m;
    private SoftReference<ImageView> ovZ;
    private BitmapFactory.Options owa;
    private d owb;

    public c(ImageView imageView, int[] iArr, int i, int i2, long j) {
        this.h = null;
        this.j = false;
        this.k = 0;
        this.m = false;
        this.ovZ = new SoftReference<>(imageView);
        this.f4213a = iArr;
        if (i > 0) {
            this.b = i;
            this.c = 1000 / i;
        }
        this.d = i2;
        this.e = 0;
        this.f = j;
        if (Build.VERSION.SDK_INT >= 11 && iArr != null && iArr.length > 0 && imageView != null) {
            imageView.setImageResource(iArr[0]);
            imageView.setVisibility(4);
            Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
            this.h = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
            this.owa = new BitmapFactory.Options();
            this.owa.inBitmap = this.h;
            this.owa.inMutable = true;
            this.owa.inSampleSize = 1;
        }
    }

    public c(ImageView imageView, int[] iArr, int i, long j) {
        this(imageView, iArr, 25, i, j);
    }

    public void a(d dVar) {
        this.owb = dVar;
    }

    public void a() {
        this.j = true;
        b();
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap bitmap;
        if (!this.m) {
            this.m = true;
            if (this.owb != null) {
                this.owb.a(this);
            }
        }
        if (this.j) {
            c();
            return;
        }
        ImageView imageView = this.ovZ.get();
        if (imageView == null) {
            c();
        } else if (this.f4213a == null || this.f4213a.length <= 0 || this.k >= this.f4213a.length) {
            c();
        } else {
            imageView.setVisibility(0);
            int i = this.f4213a[this.k];
            if (this.h != null && this.owa != null) {
                try {
                    bitmap = BitmapFactory.decodeResource(imageView.getResources(), i, this.owa);
                } catch (Exception e) {
                    e.printStackTrace();
                    bitmap = null;
                }
                if (bitmap != null) {
                    imageView.setImageBitmap(bitmap);
                } else {
                    imageView.setImageResource(i);
                    this.h.recycle();
                    this.h = null;
                }
            } else {
                imageView.setImageResource(i);
            }
            this.k++;
            if (this.j) {
                c();
            } else if (this.k >= this.f4213a.length && (this.d <= 0 || this.e >= this.d)) {
                c();
            } else if (this.k >= this.f4213a.length) {
                this.k = 0;
                this.e++;
                e.eih().b(this);
                if (this.owb != null) {
                    this.owb.b(this);
                }
            } else {
                e.eih().a(this);
            }
        }
    }

    private void c() {
        if (this.owb != null) {
            this.owb.c(this);
        }
    }

    public void b() {
        ImageView imageView = this.ovZ.get();
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }
}
