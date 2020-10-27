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
    protected int[] f4211a;
    protected int b;
    protected long c;
    protected int d;
    protected int e;
    protected long f;
    private Bitmap h;
    private boolean j;
    private int k;
    private boolean m;
    private SoftReference<ImageView> pnq;
    private BitmapFactory.Options pnr;
    private d pns;

    public c(ImageView imageView, int[] iArr, int i, int i2, long j) {
        this.h = null;
        this.j = false;
        this.k = 0;
        this.m = false;
        this.pnq = new SoftReference<>(imageView);
        this.f4211a = iArr;
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
            this.pnr = new BitmapFactory.Options();
            this.pnr.inBitmap = this.h;
            this.pnr.inMutable = true;
            this.pnr.inSampleSize = 1;
        }
    }

    public c(ImageView imageView, int[] iArr, int i, long j) {
        this(imageView, iArr, 25, i, j);
    }

    public void a(d dVar) {
        this.pns = dVar;
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
            if (this.pns != null) {
                this.pns.a(this);
            }
        }
        if (this.j) {
            c();
            return;
        }
        ImageView imageView = this.pnq.get();
        if (imageView == null) {
            c();
        } else if (this.f4211a == null || this.f4211a.length <= 0 || this.k >= this.f4211a.length) {
            c();
        } else {
            imageView.setVisibility(0);
            int i = this.f4211a[this.k];
            if (this.h != null && this.pnr != null) {
                try {
                    bitmap = BitmapFactory.decodeResource(imageView.getResources(), i, this.pnr);
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
            } else if (this.k >= this.f4211a.length && (this.d <= 0 || this.e >= this.d)) {
                c();
            } else if (this.k >= this.f4211a.length) {
                this.k = 0;
                this.e++;
                e.esh().b(this);
                if (this.pns != null) {
                    this.pns.b(this);
                }
            } else {
                e.esh().a(this);
            }
        }
    }

    private void c() {
        if (this.pns != null) {
            this.pns.c(this);
        }
    }

    public void b() {
        ImageView imageView = this.pnq.get();
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }
}
