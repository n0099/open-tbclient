package com.google.android.gms.common.images;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.internal.af;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public final class ImageManager {
    private final Context a;
    private final af b;
    private final Map c;
    private final Map d;

    /* loaded from: classes.dex */
    public final class ImageReceiver extends ResultReceiver {
        final /* synthetic */ ImageManager a;
        private final Uri b;
        private final ArrayList c;

        public Uri a() {
            return this.b;
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i, Bundle bundle) {
            BitmapDrawable bitmapDrawable = null;
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
            if (parcelFileDescriptor != null) {
                Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
                try {
                    parcelFileDescriptor.close();
                } catch (IOException e) {
                    Log.e("ImageManager", "closed failed", e);
                }
                BitmapDrawable bitmapDrawable2 = new BitmapDrawable(this.a.a.getResources(), decodeFileDescriptor);
                this.a.b.a(this.b, new WeakReference(bitmapDrawable2.getConstantState()));
                bitmapDrawable = bitmapDrawable2;
            }
            this.a.d.remove(this.b);
            int size = this.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((ListenerHolder) this.c.get(i2)).a(this.b, bitmapDrawable);
            }
        }
    }

    /* loaded from: classes.dex */
    abstract class ListenerHolder implements OnImageLoadedListener {
        protected final int a;

        @Override // com.google.android.gms.common.images.ImageManager.OnImageLoadedListener
        public abstract void a(Uri uri, Drawable drawable);

        public int hashCode() {
            return this.a;
        }
    }

    /* loaded from: classes.dex */
    public interface OnImageLoadedListener {
        void a(Uri uri, Drawable drawable);
    }

    /* loaded from: classes.dex */
    final class a extends ListenerHolder {
        final /* synthetic */ ImageManager b;
        private final WeakReference c;

        @Override // com.google.android.gms.common.images.ImageManager.ListenerHolder, com.google.android.gms.common.images.ImageManager.OnImageLoadedListener
        public void a(Uri uri, Drawable drawable) {
            ImageReceiver imageReceiver = (ImageReceiver) this.b.c.remove(this);
            OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.c.get();
            if (onImageLoadedListener != null) {
                onImageLoadedListener.a(uri, drawable);
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return (this.c == null || aVar.c == null || this.a != aVar.a) ? false : true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    final class b extends ListenerHolder {
        final /* synthetic */ ImageManager b;
        private final WeakReference c;

        @Override // com.google.android.gms.common.images.ImageManager.ListenerHolder, com.google.android.gms.common.images.ImageManager.OnImageLoadedListener
        public void a(Uri uri, Drawable drawable) {
            ImageReceiver imageReceiver = (ImageReceiver) this.b.c.remove(this);
            ImageView imageView = (ImageView) this.c.get();
            if (imageView == null || imageReceiver == null || !imageReceiver.a().equals(uri)) {
                return;
            }
            imageView.setImageDrawable(drawable);
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                return (this.c == null || bVar.c == null || this.a != bVar.a) ? false : true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    final class c implements ComponentCallbacks2 {
    }
}
