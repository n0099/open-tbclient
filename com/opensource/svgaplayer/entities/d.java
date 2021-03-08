package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.ShapeEntity;
@kotlin.e
/* loaded from: classes5.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] qbf = new int[ShapeEntity.ShapeType.values().length];
    public static final /* synthetic */ int[] qbg;
    public static final /* synthetic */ int[] qbh;

    static {
        qbf[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        qbf[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        qbf[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        qbf[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        qbg = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        qbg[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        qbg[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        qbg[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        qbh = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        qbh[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        qbh[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        qbh[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
