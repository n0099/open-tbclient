package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.ShapeEntity;
/* loaded from: classes.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] nlE = new int[ShapeEntity.ShapeType.values().length];
    public static final /* synthetic */ int[] nlF;
    public static final /* synthetic */ int[] nlG;

    static {
        nlE[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        nlE[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        nlE[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        nlE[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        nlF = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        nlF[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        nlF[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        nlF[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        nlG = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        nlG[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        nlG[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        nlG[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
