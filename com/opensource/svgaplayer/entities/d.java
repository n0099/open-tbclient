package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.ShapeEntity;
@kotlin.e
/* loaded from: classes6.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] pUm = new int[ShapeEntity.ShapeType.values().length];
    public static final /* synthetic */ int[] pUn;
    public static final /* synthetic */ int[] pUo;

    static {
        pUm[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        pUm[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        pUm[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        pUm[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        pUn = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        pUn[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        pUn[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        pUn[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        pUo = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        pUo[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        pUo[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        pUo[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
