package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.ShapeEntity;
import kotlin.h;
@h
/* loaded from: classes.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] nof = new int[ShapeEntity.ShapeType.values().length];
    public static final /* synthetic */ int[] nog;
    public static final /* synthetic */ int[] noh;

    static {
        nof[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        nof[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        nof[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        nof[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        nog = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        nog[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        nog[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        nog[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        noh = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        noh[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        noh[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        noh[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
