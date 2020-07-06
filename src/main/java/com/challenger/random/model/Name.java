package com.challenger.random.model;

import org.apache.commons.lang3.StringUtils;

public class Name {

    private final Randomizer randomizer;

    /**
     * Internal constructor, not to be used by clients.  Instances of {@link Name} should be accessed via
     * {@link Randomizer#name()}.
     */
    protected Name(Randomizer randomizer) {
        this.randomizer = randomizer;
    }

    /**
     * <p>
     * A multipart name composed of an optional prefix, a firstname and a lastname
     * or other possible variances based on locale.  Examples:
     *      <ul>
     *          <li>James Jones Jr.</li>
     *          <li>Julie Johnson</li>
     *      </ul>
     * </p>
     *
     * @return a random name with given and family names and an optional suffix.
     */
    public String name() {
        return randomizer.randomValuesService().resolve("name.name", this, randomizer);
    }

    /**
     * <p>
     * A multipart name composed of an optional prefix, a given and family name,
     * another 'firstname' for the middle name and an optional suffix such as Jr.
     * Examples:
     *      <ul>
     *          <li>Mrs. Ella Geraldine Fitzgerald</li>
     *          <li>Jason Tom Sawyer Jr.</li>
     *          <li>Helen Jessica Troy</li>
     *      </ul>
     * </p>
     *
     * @return a random name with a middle name component with optional prefix and suffix
     */
    public String nameWithMiddle() {
        return randomizer.randomValuesService().resolve("name.name_with_middle", this, randomizer);
    }

    /**
     * <p>Returns the same value as {@link #name()}</p>
     *
     * @see Name#name()
     */
    public String fullName() {
        return name();
    }

    /**
     * <p>Returns a random 'given' name such as Aaliyah, Aaron, Abagail or Abbey</p>
     *
     * @return a 'given' name such as Aaliyah, Aaron, Abagail or Abbey
     */
    public String firstName() {
        return randomizer.randomValuesService().resolve("name.first_name", this, randomizer);
    }

    /**
     * <p>Returns a random last name such as Smith, Jones or Baldwin</p>
     *
     * @return a random last name such as Smith, Jones or Baldwin
     */
    public String lastName() {
        return randomizer.randomValuesService().resolve("name.last_name", this, randomizer);
    }

    /**
     * <p>Returns a name prefix such as Mr., Mrs., Ms., Miss, or Dr.</p>
     *
     * @return a name prefix such as Mr., Mrs., Ms., Miss, or Dr.
     */
    public String prefix() {
        return randomizer.randomValuesService().resolve("name.prefix", this, randomizer);
    }

    /**
     * <p>Returns a name suffix such as Jr., Sr., I, II, III, IV, V, MD, DDS, PhD or DVM</p>
     *
     * @return a name suffix such as Jr., Sr., I, II, III, IV, V, MD, DDS, PhD or DVM
     */
    public String suffix() {
        return randomizer.randomValuesService().resolve("name.suffix", this, randomizer);
    }

    /**
     * <p>
     * A three part title composed of a descriptor level and job.  Some examples are :
     *     <ul>
     *         <li>(template) {descriptor} {level} {job}</li>
     *         <li>Lead Solutions Specialist</li>
     *         <li>National Marketing Manager</li>
     *         <li>Central Response Liaison</li>
     *     </ul>
     * </p>
     *
     * @return a random three part job title
     */
    public String title() {
        return StringUtils.join(new String[]{
                randomizer.randomValuesService().resolve("name.title.descriptor", this, randomizer),
                randomizer.randomValuesService().resolve("name.title.level", this, randomizer),
                randomizer.randomValuesService().resolve("name.title.job", this, randomizer)}, " ");
    }

    /**
     * <p>
     * A lowercase username composed of the first_name and last_name joined with a '.'. Some examples are:
     *     <ul>
     *         <li>(template) {@link #firstName()}.{@link #lastName()}</li>
     *         <li>jim.jones</li>
     *         <li>jason.leigh</li>
     *         <li>tracy.jordan</li>
     *     </ul>
     * </p>
     *
     * @return a random two part user name.
     * @see Name#firstName()
     * @see Name#lastName()
     */
    public String username() {

        String username = StringUtils.join(
                firstName().replaceAll("'", "").toLowerCase(),
                ".",
                lastName().replaceAll("'", "").toLowerCase()
        );

        return StringUtils.deleteWhitespace(username);
    }

    /**
     * <p>Returns a blood group such as O−, O+, A-, A+, B-, B+, AB-, AB+</p>
     *
     * @return a blood group such as O−, O+, A-, A+, B-, B+, AB-, AB+
     */
    public String bloodGroup() {
        return randomizer.randomValuesService().resolve("name.blood_group", this, randomizer);
    }

}
