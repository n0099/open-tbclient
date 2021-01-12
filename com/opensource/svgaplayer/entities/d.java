package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.ShapeEntity;
@kotlin.e
/* loaded from: classes5.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] pPM = new int[ShapeEntity.ShapeType.values().length];
    public static final /* synthetic */ int[] pPN;
    public static final /* synthetic */ int[] pPO;

    static {
        pPM[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        pPM[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        pPM[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        pPM[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        pPN = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        pPN[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        pPN[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        pPN[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        pPO = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        pPO[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        pPO[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        pPO[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
