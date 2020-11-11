package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.ShapeEntity;
import kotlin.h;
@h
/* loaded from: classes15.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] pEM = new int[ShapeEntity.ShapeType.values().length];
    public static final /* synthetic */ int[] pEN;
    public static final /* synthetic */ int[] pEO;

    static {
        pEM[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        pEM[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        pEM[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        pEM[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        pEN = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        pEN[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        pEN[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        pEN[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        pEO = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        pEO[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        pEO[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        pEO[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
