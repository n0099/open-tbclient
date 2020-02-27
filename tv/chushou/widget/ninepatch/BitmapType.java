package tv.chushou.widget.ninepatch;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public enum BitmapType {
    NinePatch { // from class: tv.chushou.widget.ninepatch.BitmapType.1
        @Override // tv.chushou.widget.ninepatch.BitmapType
        public NinePatchChunk createChunk(Bitmap bitmap) {
            return NinePatchChunk.parse(bitmap.getNinePatchChunk());
        }
    },
    RawNinePatch { // from class: tv.chushou.widget.ninepatch.BitmapType.2
        @Override // tv.chushou.widget.ninepatch.BitmapType
        protected NinePatchChunk createChunk(Bitmap bitmap) {
            try {
                return NinePatchChunk.createChunkFromRawBitmap(bitmap, false);
            } catch (DivLengthException e) {
                return NinePatchChunk.createEmptyChunk();
            } catch (WrongPaddingException e2) {
                return NinePatchChunk.createEmptyChunk();
            }
        }

        @Override // tv.chushou.widget.ninepatch.BitmapType
        protected Bitmap modifyBitmap(Resources resources, Bitmap bitmap, NinePatchChunk ninePatchChunk) {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 1, 1, bitmap.getWidth() - 2, bitmap.getHeight() - 2);
            int i = resources.getDisplayMetrics().densityDpi;
            float density = i / bitmap.getDensity();
            if (density != 1.0f) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, Math.round(createBitmap.getWidth() * density), Math.round(createBitmap.getHeight() * density), true);
                createScaledBitmap.setDensity(i);
                ninePatchChunk.padding = new Rect(Math.round(ninePatchChunk.padding.left * density), Math.round(ninePatchChunk.padding.top * density), Math.round(ninePatchChunk.padding.right * density), Math.round(ninePatchChunk.padding.bottom * density));
                recalculateDivs(density, ninePatchChunk.xDivs);
                recalculateDivs(density, ninePatchChunk.yDivs);
                return createScaledBitmap;
            }
            return createBitmap;
        }

        private void recalculateDivs(float f, ArrayList<Div> arrayList) {
            Iterator<Div> it = arrayList.iterator();
            while (it.hasNext()) {
                Div next = it.next();
                next.start = Math.round(next.start * f);
                next.stop = Math.round(next.stop * f);
            }
        }
    },
    PlainImage { // from class: tv.chushou.widget.ninepatch.BitmapType.3
        @Override // tv.chushou.widget.ninepatch.BitmapType
        protected NinePatchChunk createChunk(Bitmap bitmap) {
            return NinePatchChunk.createEmptyChunk();
        }
    },
    NULL { // from class: tv.chushou.widget.ninepatch.BitmapType.4
        @Override // tv.chushou.widget.ninepatch.BitmapType
        protected NinePatchDrawable createNinePatchDrawable(Resources resources, Bitmap bitmap, String str) {
            return null;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    public NinePatchChunk createChunk(Bitmap bitmap) {
        return NinePatchChunk.createEmptyChunk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap modifyBitmap(Resources resources, Bitmap bitmap, NinePatchChunk ninePatchChunk) {
        return bitmap;
    }

    public static BitmapType determineBitmapType(Bitmap bitmap) {
        if (bitmap == null) {
            return NULL;
        }
        byte[] ninePatchChunk = bitmap.getNinePatchChunk();
        if (ninePatchChunk != null && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            return NinePatch;
        }
        if (NinePatchChunk.isRawNinePatchBitmap(bitmap)) {
            return RawNinePatch;
        }
        return PlainImage;
    }

    public static NinePatchDrawable getNinePatchDrawable(Resources resources, Bitmap bitmap, String str) {
        return determineBitmapType(bitmap).createNinePatchDrawable(resources, bitmap, str);
    }

    protected NinePatchDrawable createNinePatchDrawable(Resources resources, Bitmap bitmap, String str) {
        NinePatchChunk createChunk = createChunk(bitmap);
        return new NinePatchDrawable(resources, modifyBitmap(resources, bitmap, createChunk), createChunk.toBytes(), createChunk.padding, str);
    }
}
