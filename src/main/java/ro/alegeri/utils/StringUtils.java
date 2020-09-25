package ro.alegeri.utils;

import java.text.Normalizer;

public class StringUtils extends org.apache.commons.lang3.StringUtils {
    /**
     * Flatten accented characters to their base characters
     * e.g. Primăria Brașov -> Primaria Brasov
     * @param string
     */
    public static String flattenAccents(final String string) {
        if (StringUtils.isBlank(string)) {
            return string;
        }
        return Normalizer.normalize(string, Normalizer.Form.NFKD).replaceAll("\\p{M}", "");
    }
}
