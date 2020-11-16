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
    private SoftReference<ImageView> pys;
    private BitmapFactory.Options pyt;
    private d pyu;

    public c(ImageView imageView, int[] iArr, int i, int i2, long j) {
        this.h = null;
        this.j = false;
        this.k = 0;
        this.m = false;
        this.pys = new SoftReference<>(imageView);
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
            this.pyt = new BitmapFactory.Options();
            this.pyt.inBitmap = this.h;
            this.pyt.inMutable = true;
            this.pyt.inSampleSize = 1;
        }
    }

    public c(ImageView imageView, int[] iArr, int i, long j) {
        this(imageView, iArr, 25, i, j);
    }

    public void a(d dVar) {
        this.pyu = dVar;
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
            if (this.pyu != null) {
                this.pyu.a(this);
            }
        }
        if (this.j) {
            c();
            return;
        }
        ImageView imageView = this.pys.get();
        if (imageView == null) {
            c();
        } else if (this.f4213a == null || this.f4213a.length <= 0 || this.k >= this.f4213a.length) {
            c();
        } else {
            imageView.setVisibility(0);
            int i = this.f4213a[this.k];
            if (this.h != null && this.pyt != null) {
                try {
                    bitmap = BitmapFactory.decodeResource(imageView.getResources(), i, this.pyt);
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
                e.evW().b(this);
                if (this.pyu != null) {
                    this.pyu.b(this);
                }
            } else {
                e.evW().a(this);
            }
        }
    }

    private void c() {
        if (this.pyu != null) {
            this.pyu.c(this);
        }
    }

    public void b() {
        ImageView imageView = this.pys.get();
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }
}
