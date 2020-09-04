package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.ShapeEntity;
import kotlin.h;
@h
/* loaded from: classes11.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] oeV = new int[ShapeEntity.ShapeType.values().length];
    public static final /* synthetic */ int[] oeW;
    public static final /* synthetic */ int[] oeX;

    static {
        oeV[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        oeV[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        oeV[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        oeV[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        oeW = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        oeW[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        oeW[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        oeW[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        oeX = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        oeX[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        oeX[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        oeX[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
