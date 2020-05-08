package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.ShapeEntity;
import kotlin.h;
@h
/* loaded from: classes.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] mKT = new int[ShapeEntity.ShapeType.values().length];
    public static final /* synthetic */ int[] mKU;
    public static final /* synthetic */ int[] mKV;

    static {
        mKT[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        mKT[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        mKT[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        mKT[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        mKU = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        mKU[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        mKU[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        mKU[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        mKV = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        mKV[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        mKV[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        mKV[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
