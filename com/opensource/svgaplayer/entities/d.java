package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.ShapeEntity;
import kotlin.h;
@h
/* loaded from: classes.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] mKQ = new int[ShapeEntity.ShapeType.values().length];
    public static final /* synthetic */ int[] mKR;
    public static final /* synthetic */ int[] mKS;

    static {
        mKQ[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        mKQ[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        mKQ[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        mKQ[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        mKR = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        mKR[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        mKR[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        mKR[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        mKS = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        mKS[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        mKS[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        mKS[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
