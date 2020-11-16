package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.ShapeEntity;
import kotlin.h;
@h
/* loaded from: classes17.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] pGp = new int[ShapeEntity.ShapeType.values().length];
    public static final /* synthetic */ int[] pGq;
    public static final /* synthetic */ int[] pGr;

    static {
        pGp[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        pGp[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        pGp[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        pGp[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        pGq = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        pGq[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        pGq[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        pGq[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        pGr = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        pGr[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        pGr[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        pGr[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
