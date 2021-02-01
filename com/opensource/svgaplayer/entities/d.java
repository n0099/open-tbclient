package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.ShapeEntity;
@kotlin.e
/* loaded from: classes6.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] pZR = new int[ShapeEntity.ShapeType.values().length];
    public static final /* synthetic */ int[] pZS;
    public static final /* synthetic */ int[] pZT;

    static {
        pZR[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        pZR[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        pZR[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        pZR[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        pZS = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        pZS[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        pZS[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        pZS[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        pZT = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        pZT[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        pZT[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        pZT[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
