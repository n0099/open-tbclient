package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.ShapeEntity;
@kotlin.e
/* loaded from: classes6.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] qar = new int[ShapeEntity.ShapeType.values().length];
    public static final /* synthetic */ int[] qas;
    public static final /* synthetic */ int[] qat;

    static {
        qar[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        qar[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        qar[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        qar[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        qas = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        qas[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        qas[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        qas[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        qat = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        qat[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        qat[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        qat[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
