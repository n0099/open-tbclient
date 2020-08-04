package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.ShapeEntity;
import kotlin.h;
@h
/* loaded from: classes8.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] nKK = new int[ShapeEntity.ShapeType.values().length];
    public static final /* synthetic */ int[] nKL;
    public static final /* synthetic */ int[] nKM;

    static {
        nKK[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        nKK[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        nKK[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        nKK[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        nKL = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        nKL[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        nKL[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        nKL[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        nKM = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        nKM[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        nKM[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        nKM[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
