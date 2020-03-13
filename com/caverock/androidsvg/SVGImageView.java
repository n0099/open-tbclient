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
import com.baidu.d.a.a;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
/* loaded from: classes12.dex */
public class SVGImageView extends ImageView {
    private static Method setLayerTypeMethod = null;

    public SVGImageView(Context context) {
        super(context);
        try {
            setLayerTypeMethod = View.class.getMethod("setLayerType", Integer.TYPE, Paint.class);
        } catch (NoSuchMethodException e) {
        }
    }

    public SVGImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        try {
            setLayerTypeMethod = View.class.getMethod("setLayerType", Integer.TYPE, Paint.class);
        } catch (NoSuchMethodException e) {
        }
        a(attributeSet, 0);
    }

    public SVGImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        try {
            setLayerTypeMethod = View.class.getMethod("setLayerType", Integer.TYPE, Paint.class);
        } catch (NoSuchMethodException e) {
        }
        a(attributeSet, i);
    }

    private void a(AttributeSet attributeSet, int i) {
        if (!isInEditMode()) {
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, a.C0065a.SVGImageView, i, 0);
            try {
                int resourceId = obtainStyledAttributes.getResourceId(a.C0065a.SVGImageView_svg, -1);
                if (resourceId != -1) {
                    setImageResource(resourceId);
                    return;
                }
                String string = obtainStyledAttributes.getString(a.C0065a.SVGImageView_svg);
                if (string != null) {
                    if (!b(Uri.parse(string), false)) {
                        setImageAsset(string);
                    }
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setSVG(SVG svg) {
        if (svg == null) {
            throw new IllegalArgumentException("Null value passed to setSVG()");
        }
        dje();
        setImageDrawable(new PictureDrawable(svg.dit()));
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        new b().execute(Integer.valueOf(i));
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        b(uri, true);
    }

    public void setImageAsset(String str) {
        new a().execute(str);
    }

    private boolean b(Uri uri, boolean z) {
        try {
            new c().execute(getContext().getContentResolver().openInputStream(uri));
            return true;
        } catch (FileNotFoundException e) {
            if (z) {
                Log.e("SVGImageView", "File not found: " + uri);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class b extends AsyncTask<Integer, Integer, Picture> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: f */
        public Picture doInBackground(Integer... numArr) {
            try {
                return SVG.J(SVGImageView.this.getContext(), numArr[0].intValue()).dit();
            } catch (SVGParseException e) {
                Log.e("SVGImageView", String.format("Error loading resource 0x%x: %s", numArr, e.getMessage()));
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Picture picture) {
            if (picture != null) {
                SVGImageView.this.dje();
                SVGImageView.this.setImageDrawable(new PictureDrawable(picture));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends AsyncTask<String, Integer, Picture> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: S */
        public Picture doInBackground(String... strArr) {
            try {
                return SVG.a(SVGImageView.this.getContext().getAssets(), strArr[0]).dit();
            } catch (SVGParseException e) {
                Log.e("SVGImageView", "Error loading file " + strArr + ": " + e.getMessage());
                return null;
            } catch (FileNotFoundException e2) {
                Log.e("SVGImageView", "File not found: " + strArr);
                return null;
            } catch (IOException e3) {
                Log.e("SVGImageView", "Unable to load asset file: " + strArr, e3);
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Picture picture) {
            if (picture != null) {
                SVGImageView.this.dje();
                SVGImageView.this.setImageDrawable(new PictureDrawable(picture));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class c extends AsyncTask<InputStream, Integer, Picture> {
        private c() {
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[CONST]}, finally: {[CONST, MOVE_EXCEPTION, AGET, INVOKE, MOVE_EXCEPTION] complete} */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Picture doInBackground(InputStream... inputStreamArr) {
            try {
                try {
                    Picture dit = SVG.n(inputStreamArr[0]).dit();
                    try {
                        inputStreamArr[0].close();
                        return dit;
                    } catch (IOException e) {
                        return dit;
                    }
                } catch (SVGParseException e2) {
                    Log.e("SVGImageView", "Parse error loading URI: " + e2.getMessage());
                    try {
                        inputStreamArr[0].close();
                    } catch (IOException e3) {
                    }
                    return null;
                }
            } catch (Throwable th) {
                try {
                    inputStreamArr[0].close();
                } catch (IOException e4) {
                }
                throw th;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Picture picture) {
            if (picture != null) {
                SVGImageView.this.dje();
                SVGImageView.this.setImageDrawable(new PictureDrawable(picture));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dje() {
        if (setLayerTypeMethod != null) {
            try {
                setLayerTypeMethod.invoke(this, Integer.valueOf(View.class.getField("LAYER_TYPE_SOFTWARE").getInt(new View(getContext()))), null);
            } catch (Exception e) {
                Log.w("SVGImageView", "Unexpected failure calling setLayerType", e);
            }
        }
    }
}
