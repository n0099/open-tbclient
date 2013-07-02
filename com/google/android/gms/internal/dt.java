package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.plus.PlusClient;
import java.io.IOException;
/* loaded from: classes.dex */
public class dt extends ImageView implements GooglePlayServicesClient.ConnectionCallbacks, PlusClient.a {
    private int a;
    private Uri b;
    private boolean c;
    private boolean d;
    private Bitmap e;
    private PlusClient f;

    /* loaded from: classes.dex */
    class a extends AsyncTask {
        private final int b;

        a(int i) {
            this.b = i;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[CONST_STR, CONST_STR, INVOKE, MOVE_EXCEPTION, INVOKE, CONST_STR, CONST_STR, INVOKE, MOVE_EXCEPTION] complete} */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Bitmap doInBackground(ParcelFileDescriptor... parcelFileDescriptorArr) {
            ParcelFileDescriptor parcelFileDescriptor = parcelFileDescriptorArr[0];
            try {
                Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
                if (this.b > 0) {
                    decodeFileDescriptor = dt.b(decodeFileDescriptor, this.b);
                } else {
                    try {
                        parcelFileDescriptor.close();
                    } catch (IOException e) {
                        Log.e("PlusImageView", "closed failed", e);
                    }
                }
                return decodeFileDescriptor;
            } finally {
                try {
                    parcelFileDescriptor.close();
                } catch (IOException e2) {
                    Log.e("PlusImageView", "closed failed", e2);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Bitmap bitmap) {
            dt.this.e = bitmap;
            if (dt.this.c) {
                dt.this.setImageBitmap(dt.this.e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap b(Bitmap bitmap, int i) {
        double width = bitmap.getWidth();
        double height = bitmap.getHeight();
        double d = width > height ? i / width : i / height;
        return Bitmap.createScaledBitmap(bitmap, (int) ((width * d) + 0.5d), (int) ((d * height) + 0.5d), true);
    }

    private void b() {
        boolean z = this.b != null && "android.resource".equals(this.b.getScheme());
        if (this.d) {
            if (this.b == null) {
                setImageBitmap(null);
            } else if (z || (this.f != null && this.f.a())) {
                if (z) {
                    setImageURI(this.b);
                } else {
                    this.f.a(this, this.b, this.a);
                }
                this.d = false;
            }
        }
    }

    @Override // com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks
    public void a() {
    }

    public void a(Uri uri, int i) {
        boolean equals = this.b == null ? uri == null : this.b.equals(uri);
        boolean z = this.a == i;
        if (equals && z) {
            return;
        }
        this.b = uri;
        this.a = i;
        this.d = true;
        b();
    }

    @Override // com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks
    public void a(Bundle bundle) {
        b();
    }

    @Override // com.google.android.gms.plus.PlusClient.a
    public void a(ConnectionResult connectionResult, ParcelFileDescriptor parcelFileDescriptor) {
        if (connectionResult.a()) {
            this.d = false;
            if (parcelFileDescriptor != null) {
                new a(this.a).execute(parcelFileDescriptor);
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.c = true;
        if (this.f != null && !this.f.b(this)) {
            this.f.a(this);
        }
        if (this.e != null) {
            setImageBitmap(this.e);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.c = false;
        if (this.f == null || !this.f.b(this)) {
            return;
        }
        this.f.c(this);
    }
}
