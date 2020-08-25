package com.kascend.chushou.player.ui.pk;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.widget.ImageView;
import java.lang.ref.SoftReference;
/* loaded from: classes6.dex */
public class c implements Runnable {
    protected int[] a;
    protected int b;
    protected long c;
    protected int d;
    protected int e;
    protected long f;
    private Bitmap h;
    private boolean j;
    private int k;
    private boolean m;
    private BitmapFactory.Options nWA;
    private d nWB;
    private SoftReference<ImageView> nWz;

    public c(ImageView imageView, int[] iArr, int i, int i2, long j) {
        this.h = null;
        this.j = false;
        this.k = 0;
        this.m = false;
        this.nWz = new SoftReference<>(imageView);
        this.a = iArr;
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
            this.nWA = new BitmapFactory.Options();
            this.nWA.inBitmap = this.h;
            this.nWA.inMutable = true;
            this.nWA.inSampleSize = 1;
        }
    }

    public c(ImageView imageView, int[] iArr, int i, long j) {
        this(imageView, iArr, 25, i, j);
    }

    public void a(d dVar) {
        this.nWB = dVar;
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
            if (this.nWB != null) {
                this.nWB.a(this);
            }
        }
        if (this.j) {
            c();
            return;
        }
        ImageView imageView = this.nWz.get();
        if (imageView == null) {
            c();
        } else if (this.a == null || this.a.length <= 0 || this.k >= this.a.length) {
            c();
        } else {
            imageView.setVisibility(0);
            int i = this.a[this.k];
            if (this.h != null && this.nWA != null) {
                try {
                    bitmap = BitmapFactory.decodeResource(imageView.getResources(), i, this.nWA);
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
            } else if (this.k >= this.a.length && (this.d <= 0 || this.e >= this.d)) {
                c();
            } else if (this.k >= this.a.length) {
                this.k = 0;
                this.e++;
                e.eap().b(this);
                if (this.nWB != null) {
                    this.nWB.b(this);
                }
            } else {
                e.eap().a(this);
            }
        }
    }

    private void c() {
        if (this.nWB != null) {
            this.nWB.c(this);
        }
    }

    public void b() {
        ImageView imageView = this.nWz.get();
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }
}
