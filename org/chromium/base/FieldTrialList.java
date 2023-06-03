package org.chromium.base;

import org.chromium.base.annotations.MainDex;
@MainDex
/* loaded from: classes2.dex */
public class FieldTrialList {

    /* loaded from: classes2.dex */
    public interface Natives {
        boolean createFieldTrial(String str, String str2);

        String findFullName(String str);

        String getVariationParameter(String str, String str2);

        void logActiveTrials();

        boolean trialExists(String str);
    }

    public static void logActiveTrials() {
        FieldTrialListJni.get().logActiveTrials();
    }

    public static boolean createFieldTrial(String str, String str2) {
        return FieldTrialListJni.get().createFieldTrial(str, str2);
    }

    public static String getVariationParameter(String str, String str2) {
        return FieldTrialListJni.get().getVariationParameter(str, str2);
    }

    public static String findFullName(String str) {
        return FieldTrialListJni.get().findFullName(str);
    }

    public static boolean trialExists(String str) {
        return FieldTrialListJni.get().trialExists(str);
    }
}
