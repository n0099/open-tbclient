package com.caverock.androidsvg;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class SVGImageView extends ImageView {

    /* renamed from: e  reason: collision with root package name */
    public static Method f30564e;

    /* loaded from: classes6.dex */
    public class b extends AsyncTask<String, Integer, Picture> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Picture doInBackground(String... strArr) {
            try {
                return SVG.f(SVGImageView.this.getContext().getAssets(), strArr[0]).l();
            } catch (SVGParseException e2) {
                Log.e("SVGImageView", "Error loading file " + strArr + ": " + e2.getMessage());
                return null;
            } catch (FileNotFoundException unused) {
                Log.e("SVGImageView", "File not found: " + strArr);
                return null;
            } catch (IOException e3) {
                Log.e("SVGImageView", "Unable to load asset file: " + strArr, e3);
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Picture picture) {
            if (picture != null) {
                SVGImageView.this.d();
                SVGImageView.this.setImageDrawable(new PictureDrawable(picture));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends AsyncTask<Integer, Integer, Picture> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Picture doInBackground(Integer... numArr) {
            try {
                return SVG.h(SVGImageView.this.getContext(), numArr[0].intValue()).l();
            } catch (SVGParseException e2) {
                Log.e("SVGImageView", String.format("Error loading resource 0x%x: %s", numArr, e2.getMessage()));
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Picture picture) {
            if (picture != null) {
                SVGImageView.this.d();
                SVGImageView.this.setImageDrawable(new PictureDrawable(picture));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends AsyncTask<InputStream, Integer, Picture> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Picture doInBackground(InputStream... inputStreamArr) {
            try {
                try {
                    Picture l = SVG.g(inputStreamArr[0]).l();
                    try {
                        inputStreamArr[0].close();
                    } catch (IOException unused) {
                    }
                    return l;
                } catch (Throwable th) {
                    try {
                        inputStreamArr[0].close();
                    } catch (IOException unused2) {
                    }
                    throw th;
                }
            } catch (SVGParseException e2) {
                Log.e("SVGImageView", "Parse error loading URI: " + e2.getMessage());
                try {
                    inputStreamArr[0].close();
                    return null;
                } catch (IOException unused3) {
                    return null;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Picture picture) {
            if (picture != null) {
                SVGImageView.this.d();
                SVGImageView.this.setImageDrawable(new PictureDrawable(picture));
            }
        }
    }

    public SVGImageView(Context context) {
        super(context);
        try {
            f30564e = View.class.getMethod("setLayerType", Integer.TYPE, Paint.class);
        } catch (NoSuchMethodException unused) {
        }
    }

    public final void b(AttributeSet attributeSet, int i2) {
        if (isInEditMode()) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, d.a.p.a.a.SVGImageView, i2, 0);
        try {
            int resourceId = obtainStyledAttributes.getResourceId(d.a.p.a.a.SVGImageView_svg, -1);
            if (resourceId != -1) {
                setImageResource(resourceId);
                return;
            }
            String string = obtainStyledAttributes.getString(d.a.p.a.a.SVGImageView_svg);
            if (string != null) {
                if (c(Uri.parse(string), false)) {
                    return;
                }
                setImageAsset(string);
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final boolean c(Uri uri, boolean z) {
        try {
            new d().execute(getContext().getContentResolver().openInputStream(uri));
            return true;
        } catch (FileNotFoundException unused) {
            if (z) {
                Log.e("SVGImageView", "File not found: " + uri);
            }
            return false;
        }
    }

    public final void d() {
        if (f30564e == null) {
            return;
        }
        try {
            f30564e.invoke(this, Integer.valueOf(View.class.getField("LAYER_TYPE_SOFTWARE").getInt(new View(getContext()))), null);
        } catch (Exception e2) {
            Log.w("SVGImageView", "Unexpected failure calling setLayerType", e2);
        }
    }

    public void setImageAsset(String str) {
        new b().execute(str);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        new c().execute(Integer.valueOf(i2));
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        c(uri, true);
    }

    public void setSVG(SVG svg) {
        if (svg != null) {
            d();
            setImageDrawable(new PictureDrawable(svg.l()));
            return;
        }
        throw new IllegalArgumentException("Null value passed to setSVG()");
    }

    public SVGImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        try {
            f30564e = View.class.getMethod("setLayerType", Integer.TYPE, Paint.class);
        } catch (NoSuchMethodException unused) {
        }
        b(attributeSet, 0);
    }

    public SVGImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        try {
            f30564e = View.class.getMethod("setLayerType", Integer.TYPE, Paint.class);
        } catch (NoSuchMethodException unused) {
        }
        b(attributeSet, i2);
    }
}
